package com.ctt.adminispmobile.viewmodel

data class LoginUiState(
    val empresa: String = "1",
    val usuario: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val success: Boolean = false,
    val error: String? = null
)