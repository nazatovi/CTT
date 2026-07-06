package com.ctt.adminispmobile.model

data class Suscriptor(

    val userName: String,

    val password: String,

    val plan: String,

    val port: Int,

    val suspendido: Boolean,

    var monitoring: MonitoringData? = null

)