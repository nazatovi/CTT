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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    appViewModel: AppViewModel,
    onOpenDetail: () -> Unit,
    viewModel: SearchViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(

        topBar = {

            CenterAlignedTopAppBar(

                title = {

                    Text("AdminISP Mobile")

                },

                navigationIcon = {

                    IconButton(onClick = { }) {

                        Text("☰")

                    }

                },

                actions = {

                    IconButton(onClick = { }) {

                        Text("⚙")

                    }

                }

            )

        }


    ) { padding ->

        Column(

            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)

        ) {
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
                    Icon(Icons.Default.Search, contentDescription = null)
                },
                placeholder = {
                    Text("Buscar usuario...")
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(

                onClick = {
                    viewModel.buscar()
                },

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("Buscar")

            }

            Spacer(modifier = Modifier.height(16.dp))

            if (uiState.loading) {

                CircularProgressIndicator()

            }

            uiState.error?.let {

                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error
                )

            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items(uiState.resultados) { suscriptor ->

                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),

                        onClick = {

                            appViewModel.selectSubscriber(suscriptor)

                            onOpenDetail()

                        }

                    ) {

                        Column(

                            modifier = Modifier.padding(16.dp)

                        ) {

                            Text(
                                text = suscriptor.userName,
                                style = MaterialTheme.typography.titleMedium
                            )
                            HorizontalDivider()

                            Spacer(modifier = Modifier.height(8.dp))

                            Text("Plan: ${suscriptor.plan}")

                            Spacer(modifier = Modifier.height(4.dp))

                            Text("Puerto: ${suscriptor.port}")

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = if (suscriptor.suspendido)
                                    "🔴 Suspendido"
                                else
                                    "🟢 Activo",
                                color = if (suscriptor.suspendido)
                                    MaterialTheme.colorScheme.error
                                else
                                    MaterialTheme.colorScheme.primary
                            )

                        }

                    }

                }

            }

        }

    }

}