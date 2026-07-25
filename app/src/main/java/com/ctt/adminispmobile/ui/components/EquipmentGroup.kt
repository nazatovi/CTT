package com.ctt.adminispmobile.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.model.infrastructure.Equipment
import com.ctt.adminispmobile.model.infrastructure.EquipmentStatus
import com.ctt.adminispmobile.util.BrowserUtils
import com.ctt.adminispmobile.util.CopyUtils
import com.ctt.adminispmobile.util.network.NetworkStatus

@Composable
fun EquipmentGroup(

    title: String,

    equipments: List<Equipment>,

    statuses: Map<String, NetworkStatus>,

    context: Context,

    onEquipmentClick: (Equipment) -> Unit

) {

    if (equipments.isEmpty()) return

    EquipmentSection(title) {

        equipments.forEach { equipment ->

            EquipmentCard(

                equipment = equipment,

                status = statuses[equipment.ip]
                    ?: NetworkStatus(EquipmentStatus.UNKNOWN),

                onOpen = {

                    BrowserUtils.openEquipment(

                        context = context,

                        ip = equipment.ip,

                        port = equipment.port

                    )

                },

                onCopy = {

                    CopyUtils.copy(

                        context,

                        "IP",

                        equipment.ip

                    )

                },

                onClick = {

                    onEquipmentClick(equipment)

                }

            )

            Spacer(

                modifier = Modifier.height(12.dp)

            )

        }

    }

}