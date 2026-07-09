package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuickActionsCard(

    onOpenRouter: () -> Unit,

    onCopyUser: () -> Unit,

    onCopyPassword: () -> Unit,

    onCopyIp: () -> Unit,

    onRestart: () -> Unit

) {

    AdminCard {

        SectionTitle("⚡ Acciones rápidas")

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp)
        )

        Column(

            verticalArrangement = Arrangement.spacedBy(12.dp),

            modifier = Modifier.fillMaxWidth()

        ) {

            ActionButton(
                text = "Abrir Router",
                icon = Icons.Default.Language,
                onClick = onOpenRouter
            )

            ActionButton(
                text = "Copiar Usuario",
                icon = Icons.Default.Person,
                onClick = onCopyUser
            )

            ActionButton(
                text = "Copiar Contraseña",
                icon = Icons.Default.Key,
                onClick = onCopyPassword
            )

            ActionButton(
                text = "Copiar IP",
                icon = Icons.Default.Language,
                onClick = onCopyIp
            )

            ActionButton(
                text = "Reiniciar Sesión",
                icon = Icons.Default.Refresh,
                onClick = onRestart
            )

        }

    }

}