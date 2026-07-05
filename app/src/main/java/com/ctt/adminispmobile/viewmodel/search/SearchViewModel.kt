package com.ctt.adminispmobile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ctt.adminispmobile.model.Suscriptor
import com.ctt.adminispmobile.repository.SearchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = SearchRepository()

    private val _resultado =
        MutableStateFlow<List<Suscriptor>>(emptyList())

    val resultado: StateFlow<List<Suscriptor>> = _resultado

    fun buscar(usuario: String) {

        viewModelScope.launch {

            _resultado.value =
                repository.buscar(usuario)

        }

    }
}