package com.ctt.adminispmobile.repository.infrastructure.data

import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.util.EquipmentFactory

fun santaMargarita() = Locality(

    name = "Santa Margarita",

    equipments = listOf(

        EquipmentFactory.router(
            ip = "192.168.69.24"
        ),

        EquipmentFactory.panel(
            name = "SurOeste",
            ip = "192.168.184.2",
            frequency = "5800",
            routerPort = "eth9"
        ),

        EquipmentFactory.panel(
            name = "SurEste",
            ip = "192.168.184.3",
            frequency = "5650",
            routerPort = "eth7"
        ),

        EquipmentFactory.panel(
            name = "Norte",
            ip = "192.168.184.4",
            frequency = "5700",
            routerPort = "eth6"
        ),

        EquipmentFactory.link(
            name = "El Nueve",
            ip = "192.168.184.5",
            frequency = "5350",
            routerPort = "eth8"
        )

    )

)