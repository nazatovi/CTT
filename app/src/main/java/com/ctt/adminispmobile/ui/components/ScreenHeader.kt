package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Router
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenHeader(

    titulo: String,

    subtitulo: String? = null

) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)

    ) {

        Icon(

            imageVector = Icons.Default.Router,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.primary

        )

        Text(

            text = titulo,

            style = MaterialTheme.typography.headlineMedium,

            color = MaterialTheme.colorScheme.onBackground

        )

        subtitulo?.let {

            Text(

                text = it,

                style = MaterialTheme.typography.bodyMedium,

                color = MaterialTheme.colorScheme.secondary

            )

        }

    }

}