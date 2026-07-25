package com.ctt.adminispmobile.util

import com.ctt.adminispmobile.model.infrastructure.Equipment
import com.ctt.adminispmobile.model.infrastructure.EquipmentType
import com.ctt.adminispmobile.model.infrastructure.Vendor

object EquipmentFactory {

    fun router(
        ip: String,
        vendor: Vendor = Vendor.MIKROTIK,
        model: String? = null
    ) = Equipment(
        name = "Router",
        ip = ip,
        port = 81,
        type = EquipmentType.ROUTER,
        vendor = vendor,
        model = model
    )

    fun panel(
        name: String,
        ip: String,
        frequency: String,
        routerPort: String? = null,
        vendor: Vendor = Vendor.CAMBIUM,
        model: String? = null
    ) = Equipment(
        name = name,
        ip = ip,
        port = 80,
        type = EquipmentType.PANEL,
        frequency = frequency,
        routerPort = routerPort,
        vendor = vendor,
        model = model
    )

    fun link(
        name: String,
        ip: String,
        frequency: String? = null,
        routerPort: String? = null,
        vendor: Vendor = Vendor.CAMBIUM,
        model: String? = null
    ) = Equipment(
        name = name,
        ip = ip,
        port = 80,
        type = EquipmentType.LINK,
        frequency = frequency,
        routerPort = routerPort,
        vendor = vendor,
        model = model
    )
}