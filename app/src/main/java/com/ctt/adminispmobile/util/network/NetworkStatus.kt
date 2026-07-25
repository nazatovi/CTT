package com.ctt.adminispmobile.util.network

data class NetworkStatus(

    val state: NetworkState,

    val responseTime: Long? = null,

    val message: String = ""

)