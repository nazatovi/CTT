package com.ctt.adminispmobile.navigation

sealed class Screen(val route: String) {

    object Login : Screen("login")

    object Home : Screen("home")

    object Search : Screen("search")

    object Detail : Screen("detail")

}