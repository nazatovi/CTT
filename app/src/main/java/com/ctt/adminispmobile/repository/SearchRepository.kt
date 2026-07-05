package com.ctt.adminispmobile.repository

import com.ctt.adminispmobile.model.Suscriptor
import com.ctt.adminispmobile.network.RetrofitClient

class SearchRepository {

    suspend fun buscar(usuario: String): List<Suscriptor> {

        val response = RetrofitClient.api.buscarSuscriptores(
            usuario = usuario
        )

        if (response.isSuccessful) {
            return response.body()?.aaData ?: emptyList()
        }

        return emptyList()
    }
}