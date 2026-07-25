package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun AdminScaffold(

    topBar: @Composable () -> Unit = {},

    content: @Composable (PaddingValues) -> Unit

) {

    Scaffold(

        topBar = topBar

    ) { padding ->

        content(padding)

    }

}