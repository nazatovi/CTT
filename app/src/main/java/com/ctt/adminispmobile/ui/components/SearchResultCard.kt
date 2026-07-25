package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Router
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.model.Suscriptor
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment

@Composable
fun SearchResultCard(

    suscriptor: Suscriptor,

    onClick: () -> Unit

) {

    AdminCard(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }

    ) {

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween,

            verticalAlignment = Alignment.CenterVertically

        ) {

            Column {

                SectionTitle(suscriptor.userName)

                Spacer(modifier = Modifier.height(4.dp))

                val tecnologia =
                    if (suscriptor.plan.contains("ftth", true))
                        "🧵 Fibra Óptica"
                    else
                        "📡 Wireless"

                androidx.compose.material3.Text(
                    text = tecnologia,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )

            }

            StatusChip(
                suspendido = suscriptor.suspendido
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(16.dp))

        IconInfoRow(

            icon = Icons.Default.Speed,

            titulo = "Plan",

            valor = suscriptor.plan

        )

        Spacer(modifier = Modifier.height(12.dp))

        IconInfoRow(

            icon = Icons.Default.Router,

            titulo = "Puerto",

            valor = suscriptor.port.toString()

        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(

            text = "Ver detalle →",

            style = MaterialTheme.typography.labelLarge,

            color = MaterialTheme.colorScheme.primary

        )

    }

}