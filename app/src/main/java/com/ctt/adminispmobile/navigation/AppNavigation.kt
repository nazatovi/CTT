package com.ctt.adminispmobile.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ctt.adminispmobile.ui.detail.DetailScreen
import com.ctt.adminispmobile.ui.login.LoginScreen
import com.ctt.adminispmobile.ui.screens.SearchScreen
import com.ctt.adminispmobile.viewmodel.AppViewModel
import com.ctt.adminispmobile.viewmodel.LoginViewModel

@Composable
fun AppNavigation(
    appViewModel: AppViewModel
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {

            val vm: LoginViewModel = viewModel()

            LoginScreen(
                viewModel = vm,
                onLoginSuccess = {
                    navController.navigate("search") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                }
            )

        }

        composable(Screen.Search.route) {
            SearchScreen(
                appViewModel = appViewModel,
                onOpenDetail = {
                    navController.navigate(Screen.Detail.route)
                }
            )
        }
        composable(Screen.Detail.route) {
            DetailScreen(
                appViewModel = appViewModel
            )
        }

    }

}