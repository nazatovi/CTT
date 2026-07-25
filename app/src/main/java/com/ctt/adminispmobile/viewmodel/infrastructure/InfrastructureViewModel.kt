package com.ctt.adminispmobile.viewmodel.infrastructure

import androidx.lifecycle.ViewModel
import com.ctt.adminispmobile.model.infrastructure.Locality
import com.ctt.adminispmobile.repository.infrastructure.InfrastructureRepository
import com.ctt.adminispmobile.util.network.NetworkStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class InfrastructureViewModel : ViewModel() {

    private val _localities =
        MutableStateFlow(InfrastructureRepository.localities)

    val localities: StateFlow<List<Locality>> =
        _localities.asStateFlow()

    fun refresh() {
        _localities.value =
            InfrastructureRepository.localities
    }

    fun updateEquipmentStatus(

        ip: String,

        status: NetworkStatus

    ) {

        val updated = _localities.value.map { locality ->

            locality.copy(

                equipments = locality.equipments.map {

                    if (it.ip == ip)

                        it.copy(

                            status = status.status,

                            latency = status.latency

                        )

                    else

                        it

                }

            )

        }

        _localities.value = updated

    }
}

