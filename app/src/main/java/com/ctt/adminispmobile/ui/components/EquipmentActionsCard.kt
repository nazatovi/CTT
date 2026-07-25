package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EquipmentActionsCard(

    onOpen: () -> Unit,

    onCopyIp: () -> Unit

) {

    AdminCard {

        Text(

            text = "Acciones rápidas",

            style = MaterialTheme.typography.titleMedium

        )

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.End

        ) {

            IconButton(

                onClick = onCopyIp

            ) {

                Icon(

                    Icons.Default.ContentCopy,

                    contentDescription = "Copiar IP"

                )

            }

            IconButton(

                onClick = onOpen

            ) {

                Icon(

                    Icons.Default.Language,

                    contentDescription = "Abrir navegador"

                )

            }

        }

    }

}