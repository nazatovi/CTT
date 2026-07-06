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
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ctt.adminispmobile.viewmodel.detail.DetailViewModel
import com.ctt.adminispmobile.ui.components.InfoRow
import com.ctt.adminispmobile.ui.components.StatusChip

@Composable
fun DetailScreen(
    appViewModel: AppViewModel,
    detailViewModel: DetailViewModel = viewModel()
) {

    val suscriptor = appViewModel.selectedSubscriber.collectAsState().value
    val uiState = detailViewModel.uiState.collectAsState().value

    if (suscriptor == null) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No hay un suscriptor seleccionado")
        }

        return
    }
    LaunchedEffect(suscriptor.userName) {

        detailViewModel.cargarMonitoreo(
            suscriptor.userName
        )

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
        if (uiState.loading) {

            Spacer(modifier = Modifier.height(8.dp))

            Text("Cargando datos de monitoreo...")

        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                InfoRow(
                    titulo = "Usuario",
                    valor = suscriptor.userName
                )

                InfoRow(
                    titulo = "Contraseña PPPoE",
                    valor = suscriptor.password
                )

                InfoRow(
                    titulo = "Plan",
                    valor = suscriptor.plan
                )

                InfoRow(
                    titulo = "Puerto",
                    valor = suscriptor.port.toString()
                )

                StatusChip(
                    suspendido = suscriptor.suspendido
                )

            }

        }
        Spacer(modifier = Modifier.height(16.dp))

        uiState.monitoring?.let { monitor ->

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        "Monitoreo",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text("IP: ${monitor.framedIpAddress}")

                    Text("Tiempo: ${monitor.acctSessionTime}")

                    Text("Inicio: ${monitor.acctStartTime}")

                    Text("MAC: ${monitor.callingStationId}")

                    Text("Última actualización: ${monitor.lastUpdate}")

                }

            }

        }

    }

}