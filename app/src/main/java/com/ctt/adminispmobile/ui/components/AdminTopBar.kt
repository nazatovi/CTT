package com.ctt.adminispmobile.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminTopBar(

    title: String,

    showBackButton: Boolean = false,

    onBackClick: (() -> Unit)? = null

) {

    CenterAlignedTopAppBar(

        title = {

            Text(

                text = title,

                style = MaterialTheme.typography.titleLarge

            )

        },

        navigationIcon = {

            if (showBackButton && onBackClick != null) {

                IconButton(

                    onClick = onBackClick

                ) {

                    Icon(

                        imageVector = Icons.Default.ArrowBack,

                        contentDescription = "Volver"

                    )

                }

            }

        }

    )

}