package com.ctt.adminispmobile.repository

import com.ctt.adminispmobile.network.RetrofitClient

class LoginRepository {

    suspend fun login(
        empresa: String,
        usuario: String,
        password: String
    ) = RetrofitClient.api.login(
        empresa,
        usuario,
        password
    )

}