package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun InfoRow(

    titulo: String,

    valor: String

) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)

    ) {

        Text(

            text = titulo.uppercase(),

            style = MaterialTheme.typography.labelMedium,

            color = MaterialTheme.colorScheme.primary

        )

        Text(

            text = valor,

            style = MaterialTheme.typography.titleMedium,

            fontWeight = FontWeight.Bold,

            modifier = Modifier.padding(top = 2.dp)

        )

        HorizontalDivider(

            modifier = Modifier.padding(top = 10.dp),

            color = MaterialTheme.colorScheme.outlineVariant

        )

    }

}