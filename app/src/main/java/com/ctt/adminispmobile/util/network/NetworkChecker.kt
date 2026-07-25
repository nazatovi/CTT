package com.ctt.adminispmobile.util.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.InetSocketAddress
import java.net.Socket
import com.ctt.adminispmobile.model.infrastructure.EquipmentStatus

object NetworkChecker {

    suspend fun check(

        ip: String,

        port: Int = 80,

        timeout: Int = 1500

    ): NetworkStatus = withContext(Dispatchers.IO) {

        val start = System.currentTimeMillis()

        try {

            Socket().use { socket ->

                socket.connect(
                    InetSocketAddress(ip, port),
                    timeout
                )

            }

            val elapsed =
                (System.currentTimeMillis() - start).toInt()

            val status = when {

                elapsed < 20 ->
                    EquipmentStatus.ONLINE

                elapsed < 80 ->
                    EquipmentStatus.SLOW

                else ->
                    EquipmentStatus.SLOW

            }

            NetworkStatus(

                status = status,

                latency = elapsed,

                message = "OK"

            )

        } catch (e: Exception) {

            NetworkStatus(

                status = EquipmentStatus.OFFLINE,

                message = e.localizedMessage ?: "Sin respuesta"

            )

        }

    }
}