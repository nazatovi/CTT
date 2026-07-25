package com.ctt.adminispmobile.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.model.infrastructure.EquipmentStatus
import com.ctt.adminispmobile.ui.components.NetworkStatusChip
import com.ctt.adminispmobile.util.network.NetworkChecker
import com.ctt.adminispmobile.util.network.NetworkStatus
import kotlinx.coroutines.launch

@Composable
fun NetworkTestScreen() {

    var status by remember {

        mutableStateOf(
            NetworkStatus(EquipmentStatus.UNKNOWN)
        )

    }

    val scope = rememberCoroutineScope()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center

    ) {

        Text(

            text = "Prueba de Conectividad",

            style = MaterialTheme.typography.headlineSmall

        )

        Spacer(modifier = Modifier.height(24.dp))

        NetworkStatusChip(status)

        Spacer(modifier = Modifier.height(24.dp))

        Button(

            onClick = {

                scope.launch {

                    status = NetworkChecker.check(

                        ip = "192.168.69.23",

                        port = 81

                    )

                }

            }

        ) {

            Text("Probar conexión")

        }

    }

}