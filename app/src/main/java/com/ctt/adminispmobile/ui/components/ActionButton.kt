package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(

    text: String,

    icon: ImageVector,

    onClick: () -> Unit

) {

    Button(

        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),

        onClick = onClick,

        colors = ButtonDefaults.buttonColors()

    ) {

        Icon(
            imageVector = icon,
            contentDescription = null
        )

        Text(
            text = "  $text"
        )

    }

}