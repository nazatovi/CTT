package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(

    title: String,

    onSearchClick: () -> Unit = {},

    onInfrastructureClick: () -> Unit = {},

    content: @Composable (PaddingValues) -> Unit

) {

    val drawerState = rememberDrawerState(
        DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(

        drawerState = drawerState,

        drawerContent = {

            ModalDrawerSheet {

                LogoAdminISP()

                Text(
                    text = "AdminISP Mobile"
                )

                NavigationDrawerItem(

                    label = {
                        Text("🏠 Buscar Suscriptores")
                    },

                    selected = false,

                    onClick = {

                        scope.launch {
                            drawerState.close()
                        }

                        onSearchClick()

                    }

                )

                NavigationDrawerItem(

                    label = {
                        Text("📡 Infraestructura")
                    },

                    selected = false,

                    onClick = {

                        scope.launch {
                            drawerState.close()
                        }

                        onInfrastructureClick()

                    }

                )

            }

        }

    ) {

        Scaffold(

            modifier = Modifier.fillMaxSize(),

            topBar = {

                CenterAlignedTopAppBar(

                    title = {

                        Text(title)

                    },

                    navigationIcon = {

                        IconButton(

                            onClick = {

                                scope.launch {

                                    drawerState.open()

                                }

                            }

                        ) {

                            Icon(

                                Icons.Default.Menu,

                                contentDescription = null

                            )

                        }

                    }

                )

            }

        ) { padding ->

            content(padding)

        }

    }

}