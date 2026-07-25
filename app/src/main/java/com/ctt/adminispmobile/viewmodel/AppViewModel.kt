package com.ctt.adminispmobile.viewmodel

import androidx.lifecycle.ViewModel
import com.ctt.adminispmobile.model.Suscriptor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.ctt.adminispmobile.model.infrastructure.Equipment

class AppViewModel : ViewModel() {

    // Suscriptor actualmente seleccionado
    private val _selectedSubscriber = MutableStateFlow<Suscriptor?>(null)

    val selectedSubscriber: StateFlow<Suscriptor?> =
        _selectedSubscriber.asStateFlow()

    fun selectSubscriber(suscriptor: Suscriptor) {
        _selectedSubscriber.value = suscriptor
    }

    fun clearSelectedSubscriber() {
        _selectedSubscriber.value = null
    }

    // Equipo de infraestructura actualmente seleccionado
    private val _selectedEquipment = MutableStateFlow<Equipment?>(null)

    val selectedEquipment: StateFlow<Equipment?> =
        _selectedEquipment.asStateFlow()

    fun selectEquipment(equipment: Equipment) {
        _selectedEquipment.value = equipment
    }

    fun clearSelectedEquipment() {
        _selectedEquipment.value = null
    }

}