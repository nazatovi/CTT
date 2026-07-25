package com.ctt.adminispmobile.navigation

sealed class Screen(val route: String) {

    object Login : Screen("login")

    object Search : Screen("search")

    object Detail : Screen("detail")

    object Infrastructure: Screen("infrastructure")

    object EquipmentDetail : Screen("equipment_detail")

}