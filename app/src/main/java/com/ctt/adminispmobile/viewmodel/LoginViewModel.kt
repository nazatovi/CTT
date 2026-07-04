package com.ctt.adminispmobile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ctt.adminispmobile.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository = LoginRepository()

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun setUsuario(usuario: String) {
        _uiState.value = _uiState.value.copy(usuario = usuario)
    }

    fun setPassword(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun login() {

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                loading = true,
                error = null
            )

            try {

                val ok = repository.login(
                    empresa = _uiState.value.empresa,
                    usuario = _uiState.value.usuario,
                    password = _uiState.value.password
                )

                _uiState.value = _uiState.value.copy(
                    loading = false,
                    success = ok,
                    error = if (ok) null else "Usuario o contraseña incorrectos"
                )

            } catch (e: Exception) {

                e.printStackTrace()

                _uiState.value = _uiState.value.copy(
                    loading = false,
                    error = "${e.javaClass.name}\n${e.message}"
                )

            }

        }

    }

}