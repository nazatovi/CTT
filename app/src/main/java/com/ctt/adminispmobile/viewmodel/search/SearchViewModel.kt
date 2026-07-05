package com.ctt.adminispmobile.viewmodel.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ctt.adminispmobile.repository.SearchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = SearchRepository()

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun setTextoBusqueda(texto: String) {
        _uiState.value = _uiState.value.copy(
            textoBusqueda = texto
        )
    }

    fun buscar() {

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                loading = true,
                error = null
            )

            try {

                val lista = repository.buscar(
                    _uiState.value.textoBusqueda
                )

                _uiState.value = _uiState.value.copy(
                    resultados = lista,
                    loading = false
                )

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(
                    loading = false,
                    error = e.message
                )

            }

        }

    }

}