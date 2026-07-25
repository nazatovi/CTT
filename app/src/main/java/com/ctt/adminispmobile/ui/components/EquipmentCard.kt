package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Router
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.model.infrastructure.Equipment
import com.ctt.adminispmobile.model.infrastructure.EquipmentType
import com.ctt.adminispmobile.util.network.NetworkStatus

@Composable
fun EquipmentCard(

    equipment: Equipment,

    status: NetworkStatus,

    onOpen: () -> Unit,

    onCopy: () -> Unit

) {

    AdminCard {

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween,

            verticalAlignment = Alignment.CenterVertically

        ) {

            Text(

                text = when (equipment.type) {

                    EquipmentType.ROUTER -> "🖥 ${equipment.name}"

                    EquipmentType.PANEL -> "📡 ${equipment.name}"

                    EquipmentType.LINK -> "📶 ${equipment.name}"

                },

                style = MaterialTheme.typography.titleMedium

            )

            NetworkStatusChip(status)

        }

        Spacer(modifier = Modifier.height(12.dp))

        InfoRow(

            titulo = "IP",

            valor = "${equipment.ip}:${equipment.port}"

        )

        equipment.frequency?.let {

            InfoRow(

                titulo = "Frecuencia",

                valor = it

            )

        }

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.End

        ) {

            IconButton(onClick = onCopy) {

                Icon(

                    Icons.Default.ContentCopy,

                    contentDescription = "Copiar"

                )

            }

            IconButton(onClick = onOpen) {

                Icon(

                    Icons.Default.Language,

                    contentDescription = "Abrir"

                )

            }

        }

    }

}