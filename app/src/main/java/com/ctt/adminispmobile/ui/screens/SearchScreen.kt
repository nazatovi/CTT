package com.ctt.adminispmobile.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ctt.adminispmobile.viewmodel.AppViewModel
import com.ctt.adminispmobile.viewmodel.search.SearchViewModel
import com.ctt.adminispmobile.ui.components.SearchResultCard
import com.ctt.adminispmobile.ui.components.LogoAdminISP
import com.ctt.adminispmobile.ui.components.MainScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(

    appViewModel: AppViewModel,

    onOpenDetail: () -> Unit,

    onOpenInfrastructure: () -> Unit,

    viewModel: SearchViewModel = viewModel()

) {

    val uiState by viewModel.uiState.collectAsState()

    MainScaffold(

        title = "Buscar Suscriptores",

        onSearchClick = {
            // Ya estamos en esta pantalla
        },

        onInfrastructureClick = {

            onOpenInfrastructure()

        }

    ) { padding ->

        Column(

            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)

        ) {
            LogoAdminISP(
                modifier = Modifier.size(72.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Bienvenido",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Buscar un Suscriptor",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(

                value = uiState.textoBusqueda,

                onValueChange = {

                    viewModel.setTextoBusqueda(it)
                    viewModel.buscar()

                },

                modifier = Modifier.fillMaxWidth(),

                singleLine = true,

                leadingIcon = {

                    Icon(
                        Icons.Default.Search,
                        contentDescription = null
                    )

                },

                label = {

                    Text("Buscar suscriptor")

                },

                placeholder = {

                    Text("Usuario, nombre o DNI")

                }

            )

            Spacer(modifier = Modifier.height(12.dp))


            if (uiState.loading) {

                CircularProgressIndicator()

            }

            uiState.error?.let {

                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error
                )

            }

            if (
                !uiState.loading &&
                uiState.resultados.isEmpty() &&
                uiState.textoBusqueda.isNotBlank()
            ) {

                Text(

                    text = "No se encontraron resultados.",

                    style = MaterialTheme.typography.bodyMedium,

                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

            if (uiState.resultados.isNotEmpty()) {

                Text(

                    text = "${uiState.resultados.size} resultado(s)",

                    style = MaterialTheme.typography.labelMedium,

                    color = MaterialTheme.colorScheme.primary

                )

                Spacer(modifier = Modifier.height(8.dp))

            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items(uiState.resultados) { suscriptor ->

                    SearchResultCard(

                        suscriptor = suscriptor,

                        onClick = {

                            appViewModel.selectSubscriber(suscriptor)

                            onOpenDetail()

                        }

                    )

                    }

                }

            }

        }

    }

