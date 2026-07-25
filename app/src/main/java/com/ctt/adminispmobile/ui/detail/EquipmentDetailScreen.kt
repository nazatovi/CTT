package com.ctt.adminispmobile.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.viewmodel.AppViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import com.ctt.adminispmobile.ui.components.EquipmentHeader
import com.ctt.adminispmobile.ui.components.AdminCard
import com.ctt.adminispmobile.ui.components.InfoRow
import androidx.compose.ui.platform.LocalContext
import com.ctt.adminispmobile.ui.components.EquipmentActionsCard
import com.ctt.adminispmobile.util.BrowserUtils
import com.ctt.adminispmobile.util.CopyUtils
import com.ctt.adminispmobile.ui.components.EquipmentInfoCard

@Composable
fun EquipmentDetailScreen(

    appViewModel: AppViewModel

) {

    val equipment =
        appViewModel.selectedEquipment.collectAsState().value

    val context = LocalContext.current

    if (equipment == null) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Text("No hay un equipo seleccionado")

        }

        return

    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {

            EquipmentHeader(

                title = equipment.name,

                subtitle = equipment.vendor.name +

                        (equipment.model?.let { " • $it" } ?: ""),

                status = equipment.status.name

            )

        }

        item {

            EquipmentActionsCard(

                onOpen = {

                    BrowserUtils.openEquipment(

                        context = context,

                        ip = equipment.ip,

                        port = equipment.port

                    )

                },

                onCopyIp = {

                    CopyUtils.copy(

                        context,

                        "IP",

                        equipment.ip

                    )

                }

            )

        }

        item {

            EquipmentInfoCard(

                equipment = equipment

            )

        }

        }
    }

