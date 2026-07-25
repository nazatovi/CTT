package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun IconInfoRow(

    icon: ImageVector,

    titulo: String,

    valor: String

) {

    Row(

        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)

    ) {

        Icon(

            imageVector = icon,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.primary

        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {

            Text(

                text = titulo,

                style = MaterialTheme.typography.labelSmall

            )

            Text(

                text = valor,

                fontWeight = FontWeight.SemiBold,

                style = MaterialTheme.typography.bodyLarge

            )

        }

    }

}