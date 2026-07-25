package com.ctt.adminispmobile.repository.infrastructure.data

import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.util.EquipmentFactory

fun villaViejo() = Locality(

    name = "Villa Viejo",

    equipments = listOf(

        EquipmentFactory.router(
            ip = "192.168.69.23"
        ),

        EquipmentFactory.panel(
            name = "NorOeste",
            ip = "192.168.190.4",
            frequency = "5450"
        ),

        EquipmentFactory.panel(
            name = "SurOeste",
            ip = "192.168.190.3",
            frequency = "5160"
        ),

        EquipmentFactory.link(
            name = "PtP Oeste",
            ip = "192.168.190.5",
            frequency = "5365"
        )

    )

)