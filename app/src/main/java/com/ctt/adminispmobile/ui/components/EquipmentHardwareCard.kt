package com.ctt.adminispmobile.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ctt.adminispmobile.model.infrastructure.Equipment

@Composable
fun EquipmentHardwareCard(

    equipment: Equipment

) {

    AdminCard {

        Text(

            text = "Hardware",

            style = MaterialTheme.typography.titleMedium

        )

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