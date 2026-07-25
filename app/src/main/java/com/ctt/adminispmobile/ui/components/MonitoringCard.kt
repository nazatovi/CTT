package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.model.MonitoringData
import com.ctt.adminispmobile.util.FormatUtils

@Composable
fun MonitoringCard(

    monitoring: MonitoringData

) {

    AdminCard {

        SectionTitle("🌐 Monitoreo")

        Spacer(modifier = Modifier.height(16.dp))

        InfoRow(
            titulo = "IP",
            valor = monitoring.framedIpAddress
        )

        InfoRow(
            titulo = "Tiempo",
            valor = monitoring.acctSessionTime
        )

        InfoRow(
            titulo = "Inicio",
            valor = monitoring.acctStartTime
        )

        InfoRow(
            titulo = "MAC",
            valor = monitoring.callingStationId
        )

        InfoRow(
            titulo = "Última actualización",
            valor = monitoring.lastUpdate
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            "Tráfico",
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        InfoRow(
            titulo = "Descarga",
            valor = FormatUtils.bytesToHuman(
                monitoring.acctOutputOctets
            )
        )

        InfoRow(
            titulo = "Subida",
            valor = FormatUtils.bytesToHuman(
                monitoring.acctInputOctets
            )
        )

    }

}