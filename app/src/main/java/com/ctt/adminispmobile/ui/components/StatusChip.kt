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

    val color = if (suspendido)
        Color(0xFFD32F2F)
    else
        Color(0xFF2E7D32)

    val texto = if (suspendido)
        "🔴 SUSPENDIDO"
    else
        "🟢 EN LÍNEA"

    Text(

        text = texto,

        modifier = Modifier
            .background(
                color.copy(alpha = 0.15f),
                RoundedCornerShape(50)
            )
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),

        color = color,

        style = MaterialTheme.typography.labelLarge

    )

}