package com.ctt.adminispmobile.util.network

import com.ctt.adminispmobile.model.infrastructure.EquipmentStatus

data class NetworkStatus(

    val status: EquipmentStatus,

    val latency: Int? = null,

    val message: String = ""

)