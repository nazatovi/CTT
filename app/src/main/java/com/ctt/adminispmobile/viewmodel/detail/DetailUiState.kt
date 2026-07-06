package com.ctt.adminispmobile.viewmodel.detail

import com.ctt.adminispmobile.model.MonitoringData

data class DetailUiState(

    val loading: Boolean = false,

    val monitoring: MonitoringData? = null,

    val error: String? = null

)