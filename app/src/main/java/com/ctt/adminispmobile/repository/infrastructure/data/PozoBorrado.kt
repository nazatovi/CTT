package com.ctt.adminispmobile.repository.infrastructure.data

import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.model.infrastructure.Vendor
import com.ctt.adminispmobile.util.EquipmentFactory

fun pozoBorrado() = Locality(

    name = "Pozo Borrado",

    equipments = listOf(

        EquipmentFactory.router(
            ip = "192.168.69.21",
            vendor = Vendor.MIKROTIK,
            model = "RB3011"
        ),

        EquipmentFactory.panel(
            name = "Norte",
            ip = "192.168.170.2",
            frequency = "5550",
            routerPort = "eth1"
        ),

        EquipmentFactory.panel(
            name = "Oeste",
            ip = "192.168.170.5",
            frequency = "5205",
            routerPort = "eth12"
        ),

        EquipmentFactory.panel(
            name = "Sur",
            ip = "192.168.170.3",
            frequency = "5610",
            routerPort = "eth9"
        ),

        EquipmentFactory.panel(
            name = "Este",
            ip = "192.168.170.4",
            frequency = "5205",
            routerPort = "eth10"
        )

    )

)