package com.ctt.adminispmobile.repository.infrastructure.data

import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.util.EquipmentFactory

fun cuatroBocas() = Locality(

    name = "Cuatro Bocas",

    equipments = listOf(

        EquipmentFactory.router(
            ip = "192.168.45.222"
        ),

        EquipmentFactory.panel(
            name = "NorOeste",
            ip = "192.168.155.2",
            frequency = "5530",
            routerPort = "eth3"
        ),

        EquipmentFactory.panel(
            name = "NorEste",
            ip = "192.168.155.3",
            frequency = "5700",
            routerPort = "eth4"
        ),

        EquipmentFactory.panel(
            name = "Este",
            ip = "192.168.155.4",
            frequency = "5280",
            routerPort = "eth5"
        )

    )

)