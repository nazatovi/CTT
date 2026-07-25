package com.ctt.adminispmobile.repository.infrastructure.data

import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.model.infrastructure.Vendor
import com.ctt.adminispmobile.util.EquipmentFactory

fun sanBernardo() = Locality(

    name = "San Bernardo",

    equipments = listOf(

        EquipmentFactory.router(
            ip = "192.168.69.30",
            vendor = Vendor.MIKROTIK,
            model = "RB3011"
        ),

        EquipmentFactory.panel(
            name = "SurOeste",
            ip = "192.168.175.2",
            frequency = "5400",
            routerPort = "eth2"
        ),

        EquipmentFactory.panel(
            name = "NorOeste",
            ip = "192.168.175.3",
            frequency = "5550",
            routerPort = "eth3"
        ),

        EquipmentFactory.panel(
            name = "Este",
            ip = "192.168.175.4",
            frequency = "5100",
            routerPort = "eth1"
        ),

        EquipmentFactory.link(
            name = "La Carreta",
            ip = "192.168.175.5",
            frequency = "5960",
            routerPort = "eth5"
        )

    )

)