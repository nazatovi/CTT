package com.ctt.adminispmobile.repository

import android.util.Log
import com.ctt.adminispmobile.network.RetrofitClient

class LoginRepository {

    suspend fun login(
        empresa: String,
        usuario: String,
        password: String
    ): Boolean {

        // 1. Crear la sesión (obtiene el JSESSIONID)
        RetrofitClient.api.initAction()

        // 2. Enviar el formulario de login
        val loginResponse = RetrofitClient.api.login(
            empresa,
            usuario,
            password
        )

        Log.d("LOGIN", "Código Login = ${loginResponse.code()}")

        // 3. Volver a cargar initAction con la cookie obtenida
        val initResponse = RetrofitClient.api.initAction()

        Log.d("LOGIN", "Código Init = ${initResponse.code()}")

        val html = initResponse.body()?.string().orEmpty()

        Log.d("LOGIN", html)

        // Si sigue apareciendo el formulario de login,
        // entonces la autenticación falló.
        return !html.contains("Iniciar Sesion", ignoreCase = true)
    }

}