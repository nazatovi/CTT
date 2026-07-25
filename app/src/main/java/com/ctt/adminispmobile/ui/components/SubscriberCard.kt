package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.model.Suscriptor

@Composable
fun SubscriberCard(

    suscriptor: Suscriptor

) {

    AdminCard {

        SectionTitle("👤 Suscriptor")

        Spacer(modifier = Modifier.height(16.dp))

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