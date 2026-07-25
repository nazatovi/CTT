package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun EquipmentHeader(

    title: String,

    subtitle: String,

    status: String

) {

    Column {

        Text(

            text = title,

            style = MaterialTheme.typography.headlineSmall

        )

        Text(

            text = subtitle,

            style = MaterialTheme.typography.titleMedium

        )

        Text(

            text = status,

            style = MaterialTheme.typography.bodyMedium

        )

    }

}