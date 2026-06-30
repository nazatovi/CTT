package com.ctt.adminispmobile.model

data class LoginRequest(
    val empresa: String,
    val username: String,
    val password: String
)