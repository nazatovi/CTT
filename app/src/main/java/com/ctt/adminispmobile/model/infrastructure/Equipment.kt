package com.ctt.adminispmobile.model.infrastructure

data class Equipment(

    val name: String,

    val ip: String,

    val port: Int = 80,

    val type: EquipmentType,

    val frequency: String? = null,

    val routerPort: String? = null,

    val vendor: Vendor = Vendor.GENERIC,

    val model: String? = null,

    val notes: String? = null,

    val status: EquipmentStatus = EquipmentStatus.UNKNOWN,

    val latency: Int? = null

)