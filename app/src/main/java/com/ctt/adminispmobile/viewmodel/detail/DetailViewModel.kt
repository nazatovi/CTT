package com.ctt.adminispmobile.viewmodel.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ctt.adminispmobile.repository.MonitoringRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val repository = MonitoringRepository()

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun cargarMonitoreo(usuario: String) {

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                loading = true,
                error = null
            )

            try {

                val monitoring = repository.buscar(usuario)

                _uiState.value = _uiState.value.copy(
                    loading = false,
                    monitoring = monitoring
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