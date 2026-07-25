package com.ctt.adminispmobile.repository.infrastructure.data

import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.util.EquipmentFactory

fun elCuadrado() = Locality(

    name = "El Cuadrado",

    equipments = listOf(

        EquipmentFactory.router(
            ip = "192.168.69.25"
        ),

        EquipmentFactory.panel(
            name = "Panel 1",
            ip = "192.168.158.2",
            frequency = "5500"
        ),

        EquipmentFactory.panel(
            name = "Panel 2",
            ip = "192.168.158.3",
            frequency = "5300"
        ),

        EquipmentFactory.panel(
            name = "Panel 3",
            ip = "192.168.158.4",
            frequency = "5600"
        ),

        EquipmentFactory.panel(
            name = "Panel 4",
            ip = "192.168.158.6",
            frequency = "5400"
        )

    )

)