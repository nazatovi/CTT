package com.ctt.adminispmobile.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.util.network.NetworkChecker
import com.ctt.adminispmobile.util.network.NetworkStatus
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import com.ctt.adminispmobile.model.infrastructure.EquipmentType
import com.ctt.adminispmobile.model.infrastructure.Equipment
import androidx.compose.ui.platform.LocalContext
import com.ctt.adminispmobile.util.BrowserUtils
import com.ctt.adminispmobile.util.CopyUtils

@Composable
fun LocalityCard(

    locality: Locality,

    onEquipmentClick: (Equipment) -> Unit

) {

    var expanded by remember {

        mutableStateOf(false)

    }

    val context = LocalContext.current

    var statuses by remember {

        mutableStateOf(
            emptyMap<String, NetworkStatus>()
        )

    }

    LaunchedEffect(expanded) {

        if (expanded) {

            statuses = coroutineScope {

                locality.equipments

                    .map { equipment ->

                        async {

                            equipment.ip to NetworkChecker.check(

                                ip = equipment.ip,

                                port = equipment.port

                            )

                        }

                    }

                    .awaitAll()

                    .toMap()

            }

        }

    }

    AdminCard(

        modifier = Modifier.clickable {

            expanded = !expanded

        }

    ) {

        androidx.compose.foundation.layout.Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Text(

                locality.name,

                style = MaterialTheme.typography.titleLarge

            )

            Icon(

                imageVector =
                    if (expanded)
                        Icons.Default.ExpandLess
                    else
                        Icons.Default.ExpandMore,

                contentDescription = null

            )

        }

        val routers = locality.equipments.filter {

            it.type == EquipmentType.ROUTER

        }

        val panels = locality.equipments.filter {

            it.type == EquipmentType.PANEL

        }

        val links = locality.equipments.filter {

            it.type == EquipmentType.LINK

        }

        AnimatedVisibility(expanded) {

            Column {

                AnimatedVisibility(expanded) {

                    Column {

                        EquipmentGroup(

                            title = "🖥 ROUTERS",

                            equipments = routers,

                            statuses = statuses,

                            context = context,

                            onEquipmentClick = onEquipmentClick

                        )

                        EquipmentGroup(

                            title = "📡 PANELES",

                            equipments = panels,

                            statuses = statuses,

                            context = context,

                            onEquipmentClick = onEquipmentClick

                        )

                        EquipmentGroup(

                            title = "📶 ENLACES",

                            equipments = links,

                            statuses = statuses,

                            context = context,

                            onEquipmentClick = onEquipmentClick

                        )

                    }

                }

            }

        }

    }

}