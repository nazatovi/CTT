package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SubscriberHeader(

    usuario: String,

    plan: String,

    ip: String?,

    suspendido: Boolean

) {

    val colors = if (suspendido) {

        listOf(
            Color(0xFFB71C1C),
            Color(0xFFE57373)
        )

    } else {

        listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.primary.copy(alpha = 0.65f)
        )

    }

    Box(

        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(colors),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(24.dp)

    ) {

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier.fillMaxWidth()

        ) {

            Text(

                text = usuario,

                style = MaterialTheme.typography.headlineSmall,

                color = Color.White,

                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(

                text = plan,

                style = MaterialTheme.typography.titleMedium,

                color = Color.White.copy(alpha = .95f)

            )

            Spacer(modifier = Modifier.height(16.dp))

            StatusChip(
                suspendido = suspendido
            )

            if (!ip.isNullOrBlank()) {

                Spacer(modifier = Modifier.height(16.dp))

                Row(

                    verticalAlignment = Alignment.CenterVertically

                ) {

                    androidx.compose.material3.Icon(

                        imageVector = Icons.Default.Public,

                        contentDescription = null,

                        tint = Color.White

                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(

                        text = ip,

                        color = Color.White,

                        style = MaterialTheme.typography.bodyLarge

                    )

                }

            }

        }

    }

}