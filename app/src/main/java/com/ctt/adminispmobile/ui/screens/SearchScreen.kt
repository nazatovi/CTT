package com.ctt.adminispmobile.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ctt.adminispmobile.viewmodel.search.SearchViewModel
import com.ctt.adminispmobile.viewmodel.AppViewModel

@Composable
fun SearchScreen(
    appViewModel: AppViewModel,
    onOpenDetail: () -> Unit,
    viewModel: SearchViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Buscar Suscriptor",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.textoBusqueda,
            onValueChange = viewModel::setTextoBusqueda,
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
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

        LazyColumn {

            items(uiState.resultados) { suscriptor ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
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

                        Text("Plan: ${suscriptor.plan}")

                        Text("Puerto: ${suscriptor.port}")

                        Text(
                            if (suscriptor.suspendido)
                                "Suspendido"
                            else
                                "Activo"
                        )

                    }

                }

            }

        }

    }

}