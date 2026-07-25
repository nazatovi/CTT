package com.ctt.adminispmobile.repository.infrastructure.data

import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.util.EquipmentFactory

fun malvinasArgentinas() = Locality(

    name = "Malvinas Argentinas",

    equipments = listOf(

        EquipmentFactory.router(
            ip = "192.168.69.27"
        ),

        EquipmentFactory.panel(
            name = "Sur",
            ip = "192.168.202.3",
            frequency = "5600",
            routerPort = "eth8"
        ),

        EquipmentFactory.panel(
            name = "NorOeste",
            ip = "192.168.202.2",
            frequency = "5200",
            routerPort = "eth7"
        ),

        EquipmentFactory.panel(
            name = "NorEste",
            ip = "192.168.202.4",
            frequency = "5700",
            routerPort = "eth6"
        ),

        EquipmentFactory.link(
            name = "El Descanso",
            ip = "192.168.202.5",
            frequency = "5415",
            routerPort = "eth4"
        )

    )

)