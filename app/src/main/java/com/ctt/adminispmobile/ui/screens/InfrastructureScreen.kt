package com.ctt.adminispmobile.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.repository.infrastructure.InfrastructureRepository
import com.ctt.adminispmobile.ui.components.LocalityCard
import com.ctt.adminispmobile.ui.components.MainScaffold
import com.ctt.adminispmobile.viewmodel.AppViewModel

@Composable
fun InfrastructureScreen(

    appViewModel: AppViewModel,

    onSearchClick: () -> Unit,

    onOpenEquipmentDetail: () -> Unit

) {

    MainScaffold(

        title = "Infraestructura",

        onSearchClick = onSearchClick,

        onInfrastructureClick = { }

    ) { padding ->

        Column(

            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)

        ) {

            Text(

                text = "Infraestructura de Red",

                style = MaterialTheme.typography.headlineSmall

            )

            Text(

                text = "Monitoreo en tiempo real",

                style = MaterialTheme.typography.bodyMedium

            )

            LazyColumn(

                modifier = Modifier.padding(top = 20.dp),

                verticalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                items(InfrastructureRepository.localities) { locality ->

                    LocalityCard(

                        locality = locality,

                        onEquipmentClick = { equipment ->

                            appViewModel.selectEquipment(equipment)

                            onOpenEquipmentDetail()

                        }

                    )

                }

            }

        }

    }

}