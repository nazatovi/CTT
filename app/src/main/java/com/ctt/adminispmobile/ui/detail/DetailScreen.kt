package com.ctt.adminispmobile.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.viewmodel.AppViewModel

@Composable
fun DetailScreen(
    appViewModel: AppViewModel
) {

    val suscriptor = appViewModel.selectedSubscriber.collectAsState().value

    if (suscriptor == null) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No hay un suscriptor seleccionado")
        }

        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Detalle del Suscriptor",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Usuario: ${suscriptor.userName}")

                Spacer(modifier = Modifier.height(8.dp))

                Text("Plan: ${suscriptor.plan}")

                Spacer(modifier = Modifier.height(8.dp))

                Text("Puerto: ${suscriptor.port}")

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    if (suscriptor.suspendido)
                        "Estado: Suspendido"
                    else
                        "Estado: Activo"
                )

            }

        }

    }

}