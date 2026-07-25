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

@Composable
fun EquipmentDetailScreen(

    appViewModel: AppViewModel

) {

    val equipment =
        appViewModel.selectedEquipment.collectAsState().value

    if (equipment == null) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Text("No hay un equipo seleccionado")

        }

        return

    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {

        Text(

            text = equipment.name,

            style = MaterialTheme.typography.headlineMedium

        )

        Text("IP: ${equipment.ip}")

        Text("Puerto: ${equipment.port}")

        Text("Fabricante: ${equipment.vendor}")

        equipment.model?.let {

            Text("Modelo: $it")

        }

        equipment.frequency?.let {

            Text("Frecuencia: ${it} MHz")

        }

        equipment.routerPort?.let {

            Text("Puerto Router: $it")

        }

    }

}