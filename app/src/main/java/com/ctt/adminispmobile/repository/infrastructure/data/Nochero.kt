package com.ctt.adminispmobile.repository.infrastructure.data

import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.util.EquipmentFactory

fun nochero() = Locality(

    name = "Nochero",

    equipments = listOf(

        EquipmentFactory.router(
            ip = "192.168.69.26"
        ),

        EquipmentFactory.panel(
            name = "NorOeste",
            ip = "192.168.198.2",
            frequency = "5450"
        ),

        EquipmentFactory.panel(
            name = "SurOeste",
            ip = "192.168.198.3",
            frequency = "5300"
        ),

        EquipmentFactory.panel(
            name = "Este",
            ip = "192.168.198.4",
            frequency = "5400"
        )

    )

)