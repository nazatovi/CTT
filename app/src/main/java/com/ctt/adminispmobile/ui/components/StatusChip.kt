package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StatusChip(
    suspendido: Boolean
) {

    val fondo = if (suspendido)
        Color(0xFFD32F2F)
    else
        Color(0xFF2E7D32)

    val texto = if (suspendido)
        "Suspendido"
    else
        "Activo"

    Text(

        text = texto,

        color = Color.White,

        style = MaterialTheme.typography.labelLarge,

        modifier = Modifier
            .background(
                color = fondo,
                shape = RoundedCornerShape(50)
            )
            .padding(
                horizontal = 14.dp,
                vertical = 6.dp
            )

    )

}