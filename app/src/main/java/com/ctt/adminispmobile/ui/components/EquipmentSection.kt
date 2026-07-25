package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EquipmentSection(

    title: String,

    content: @Composable () -> Unit

) {

    Spacer(modifier = Modifier.height(12.dp))

    HorizontalDivider()

    Spacer(modifier = Modifier.height(12.dp))

    Text(

        text = title,

        style = MaterialTheme.typography.titleSmall,

        color = MaterialTheme.colorScheme.primary

    )

    Spacer(modifier = Modifier.height(12.dp))

    Column {

        content()

    }

}