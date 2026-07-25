package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.util.network.NetworkState
import com.ctt.adminispmobile.util.network.NetworkStatus

@Composable
fun NetworkStatusChip(

    status: NetworkStatus

) {

    val background: Color
    val text: String

    when (status.state) {

        NetworkState.ONLINE -> {

            background = Color(0xFF4CAF50)
            text = "🟢 Online"

        }

        NetworkState.SLOW -> {

            background = Color(0xFFFF9800)
            text = "🟡 Lento"

        }

        NetworkState.OFFLINE -> {

            background = Color(0xFFF44336)
            text = "🔴 Offline"

        }

        else -> {

            background = Color.Gray
            text = "⚪ Desconocido"

        }

    }

    Row(

        horizontalArrangement = Arrangement.spacedBy(6.dp),

        modifier = Modifier
            .background(
                background,
                RoundedCornerShape(50)
            )
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            )

    ) {

        Text(

            text = text,

            color = Color.White,

            style = MaterialTheme.typography.labelMedium

        )

        status.responseTime?.let {

            Text(

                text = "${it} ms",

                color = Color.White,

                style = MaterialTheme.typography.labelMedium

            )

        }

    }

}