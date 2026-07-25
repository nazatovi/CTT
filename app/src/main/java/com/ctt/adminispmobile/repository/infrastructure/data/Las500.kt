package com.ctt.adminispmobile.repository.infrastructure.data

import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.util.EquipmentFactory

fun las500() = Locality(

    name = "Las 500",

    equipments = listOf(

        EquipmentFactory.router(
            ip = "192.168.69.36"
        ),

        EquipmentFactory.panel(
            name = "SurEste",
            ip = "10.232.0.2",
            frequency = "5500",
            routerPort = "eth6"
        ),

        EquipmentFactory.panel(
            name = "Panel 2",
            ip = "10.232.0.3",
            frequency = "5450",
            routerPort = "eth7"
        ),

        EquipmentFactory.panel(
            name = "Panel 3",
            ip = "10.232.0.4",
            frequency = "5650",
            routerPort = "eth8"
        )

    )

)