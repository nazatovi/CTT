package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InfoRow(

    titulo: String,

    valor: String

) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)

    ) {

        Text(

            text = titulo,

            style = MaterialTheme.typography.labelMedium,

            color = MaterialTheme.colorScheme.primary

        )

        Spacer(
            modifier = Modifier.height(2.dp)
        )

        Text(

            text = valor,

            style = MaterialTheme.typography.bodyLarge

        )

    }

}