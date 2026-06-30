package com.ctt.adminispmobile.util

object ServerConfig {

    var ip: String = "172.31.1.12"

    var port: Int = 8080

    fun baseUrl(): String {
        return "http://$ip:$port/"
    }
}