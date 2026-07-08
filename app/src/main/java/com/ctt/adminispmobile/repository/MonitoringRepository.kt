package com.ctt.adminispmobile.repository

import com.ctt.adminispmobile.model.MonitoringData
import com.ctt.adminispmobile.network.RetrofitClient

class MonitoringRepository {

    suspend fun buscar(usuario: String): MonitoringData? {

        val response = RetrofitClient.api.buscarMonitoreo(

            filtros = ",userName like '%$usuario%'"

        )

        if (response.isSuccessful) {

            return response.body()
                ?.aaData
                ?.firstOrNull()

        }

        return null

    }

    suspend fun reiniciarSesion(
        id: Long
    ): Boolean {

        val response = RetrofitClient.api.reiniciarSesion(id)

        return response.isSuccessful &&
                response.body() == true

    }

}