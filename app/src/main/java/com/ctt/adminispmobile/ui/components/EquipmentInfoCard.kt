package com.ctt.adminispmobile.ui.components

import androidx.compose.runtime.Composable
import com.ctt.adminispmobile.model.infrastructure.Equipment

@Composable
fun EquipmentInfoCard(

    equipment: Equipment

) {

    AdminCard {

        InfoRow(

            titulo = "IP",

            valor = equipment.ip

        )

        InfoRow(

            titulo = "Puerto",

            valor = equipment.port.toString()

        )

        equipment.frequency?.let {

            InfoRow(

                titulo = "Frecuencia",

                valor = "$it MHz"

            )

        }

        equipment.routerPort?.let {

            InfoRow(

                titulo = "Puerto Router",

                valor = it

            )

        }

        InfoRow(

            titulo = "Fabricante",

            valor = equipment.vendor.name

        )

        equipment.model?.let {

            InfoRow(

                titulo = "Modelo",

                valor = it

            )

        }

    }

}