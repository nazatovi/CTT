package com.ctt.adminispmobile.repository.infrastructure.data

import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.util.EquipmentFactory

fun villaNuevo() = Locality(

    name = "Villa Nuevo",

    equipments = listOf(

        EquipmentFactory.router(
            ip = "192.168.69.23"
        ),

        EquipmentFactory.panel(
            name = "Oeste",
            ip = "10.190.0.2",
            frequency = "5900"
        ),

        EquipmentFactory.panel(
            name = "Oeste II",
            ip = "10.190.0.6",
            frequency = "5750"
        ),

        EquipmentFactory.panel(
            name = "Sur",
            ip = "10.190.0.3",
            frequency = "4950"
        ),

        EquipmentFactory.panel(
            name = "Norte",
            ip = "10.190.0.4",
            frequency = "5960"
        )

    )

)