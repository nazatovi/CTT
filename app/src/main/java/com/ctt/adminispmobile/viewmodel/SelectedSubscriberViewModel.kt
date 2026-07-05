package com.ctt.adminispmobile.viewmodel

import androidx.lifecycle.ViewModel
import com.ctt.adminispmobile.model.Suscriptor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedSubscriberViewModel : ViewModel() {

    private val _selected = MutableStateFlow<Suscriptor?>(null)

    val selected: StateFlow<Suscriptor?> = _selected.asStateFlow()

    fun select(suscriptor: Suscriptor) {
        _selected.value = suscriptor
    }

}