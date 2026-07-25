package com.ctt.adminispmobile.util.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.InetSocketAddress
import java.net.Socket

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
                System.currentTimeMillis() - start

            val state = when {

                elapsed < 20 ->
                    NetworkState.ONLINE

                elapsed < 80 ->
                    NetworkState.SLOW

                else ->
                    NetworkState.SLOW

            }

            NetworkStatus(

                state = state,

                responseTime = elapsed,

                message = "OK"

            )

        } catch (e: Exception) {

            NetworkStatus(

                state = NetworkState.OFFLINE,

                message = e.localizedMessage ?: "Sin respuesta"

            )

        }

    }

}