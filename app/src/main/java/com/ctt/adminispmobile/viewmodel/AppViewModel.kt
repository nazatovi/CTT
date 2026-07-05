package com.ctt.adminispmobile.viewmodel

import androidx.lifecycle.ViewModel
import com.ctt.adminispmobile.model.Suscriptor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

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

}