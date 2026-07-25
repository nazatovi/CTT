package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.NetworkPing
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.model.infrastructure.Equipment
import com.ctt.adminispmobile.model.infrastructure.EquipmentStatus
import com.ctt.adminispmobile.model.infrastructure.EquipmentType
import androidx.compose.ui.platform.LocalContext
import com.ctt.adminispmobile.util.BrowserUtils

@Composable

fun InfrastructureEquipmentCard(

    equipment: Equipment,

    onOpen: () -> Unit = {},

    onPing: () -> Unit = {},

    onCopyIp: () -> Unit = {},

    onFavorite: () -> Unit = {}

) {
    val context = LocalContext.current
    Card(

        modifier = Modifier.fillMaxWidth(),

        elevation = CardDefaults.cardElevation(4.dp)

    ) {

        Column(

            modifier = Modifier.padding(16.dp)

        ) {

            val icon = when (equipment.type) {

                EquipmentType.ROUTER -> "🛜"

                EquipmentType.PANEL -> "📡"

                EquipmentType.LINK -> "🔗"

            }

            val status = when (equipment.status) {

                EquipmentStatus.ONLINE -> "🟢"

                EquipmentStatus.SLOW -> "🟠"

                EquipmentStatus.OFFLINE -> "🔴"

                EquipmentStatus.UNKNOWN -> "⚪"

            }

            Text(

                text = "$status $icon ${equipment.name}",

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(8.dp))

            equipment.model?.let {

                Text(it)

            }

            Text(

                equipment.vendor.name

            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("IP: ${equipment.ip}")

            equipment.frequency?.let {

                Text("Frecuencia: $it MHz")

            }

            equipment.routerPort?.let {

                Text("Puerto: $it")

            }

            equipment.latency?.let {

                Text("Latencia: ${it} ms")

            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(

                horizontalArrangement = Arrangement.SpaceEvenly,

                modifier = Modifier.fillMaxWidth()

            ) {

                IconButton(

                    onClick = {

                        BrowserUtils.openEquipment(

                            context,

                            equipment.ip,

                            equipment.port

                        )

                        onOpen()

                    }

                ) {

                    Icon(

                        Icons.Default.Language,

                        contentDescription = "Abrir"

                    )

                }

                IconButton(onClick = onPing) {

                    Icon(

                        Icons.Default.NetworkPing,

                        contentDescription = "Ping"

                    )

                }

                IconButton(onClick = onCopyIp) {

                    Icon(

                        Icons.Default.ContentCopy,

                        contentDescription = "Copiar"

                    )

                }

                IconButton(onClick = onFavorite) {

                    Icon(

                        Icons.Default.StarBorder,

                        contentDescription = "Favorito"

                    )

                }

            }

        }

    }

}