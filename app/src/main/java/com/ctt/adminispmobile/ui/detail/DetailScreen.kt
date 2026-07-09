package com.ctt.adminispmobile.ui.detail

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ctt.adminispmobile.ui.components.ActionButton
import com.ctt.adminispmobile.ui.components.InfoRow
import com.ctt.adminispmobile.ui.components.StatusChip
import com.ctt.adminispmobile.util.CopyUtils
import com.ctt.adminispmobile.util.FormatUtils
import com.ctt.adminispmobile.util.RouterUtils
import com.ctt.adminispmobile.viewmodel.AppViewModel
import com.ctt.adminispmobile.viewmodel.detail.DetailViewModel
import com.ctt.adminispmobile.ui.components.AdminCard
import com.ctt.adminispmobile.ui.components.ScreenHeader
import com.ctt.adminispmobile.ui.components.QuickActionsCard
@Composable
fun DetailScreen(
    appViewModel: AppViewModel,
    detailViewModel: DetailViewModel = viewModel()
) {

    val suscriptor = appViewModel.selectedSubscriber.collectAsState().value
    val context = LocalContext.current
    val uiState = detailViewModel.uiState.collectAsState().value

    var showRestartDialog by remember {
        mutableStateOf(false)
    }

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

    LazyColumn(

        modifier = Modifier.fillMaxSize(),

        contentPadding = PaddingValues(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {

        item {

            ScreenHeader(

                titulo = suscriptor.userName,

                subtitulo = "Detalle del Suscriptor"

            )

        }

        if (uiState.loading) {

            item {

                Text("Cargando datos de monitoreo...")

            }

        }

        item {

            AdminCard {

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

                Spacer(modifier = Modifier.height(12.dp))

                StatusChip(
                    suspendido = suscriptor.suspendido
                )

            }

        }

        uiState.monitoring?.let { monitor ->

            item {

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

                        Spacer(modifier = Modifier.height(12.dp))

                        InfoRow(
                            titulo = "Descarga",
                            valor = FormatUtils.bytesToHuman(
                                monitor.acctOutputOctets
                            )
                        )

                        InfoRow(
                            titulo = "Subida",
                            valor = FormatUtils.bytesToHuman(
                                monitor.acctInputOctets
                            )
                        )

                    }

                }

            }

        }

        item {

            QuickActionsCard(

                onOpenRouter = {

                    uiState.monitoring?.let {

                        RouterUtils.open(
                            context,
                            it.framedIpAddress
                        )

                    }

                },

                onCopyUser = {

                    CopyUtils.copy(
                        context,
                        "Usuario",
                        suscriptor.userName
                    )

                },

                onCopyPassword = {

                    CopyUtils.copy(
                        context,
                        "Contraseña",
                        suscriptor.password
                    )

                },

                onCopyIp = {

                    uiState.monitoring?.let {

                        CopyUtils.copy(
                            context,
                            "IP",
                            it.framedIpAddress
                        )

                    }

                },

                onRestart = {

                    showRestartDialog = true

                }

            )

        }

    }

    if (showRestartDialog) {

        AlertDialog(

            onDismissRequest = {

                showRestartDialog = false

            },

            title = {

                Text("Reiniciar sesión")

            },

            text = {

                Text(
                    "¿Desea reiniciar la sesión PPPoE del usuario ${suscriptor.userName}?"
                )

            },

            confirmButton = {

                TextButton(

                    onClick = {

                        showRestartDialog = false

                        detailViewModel.reiniciarSesion()

                    }

                ) {

                    Text("Reiniciar")

                }

            },

            dismissButton = {

                TextButton(

                    onClick = {

                        showRestartDialog = false

                    }

                ) {

                    Text("Cancelar")

                }

            }

        )

    }

}