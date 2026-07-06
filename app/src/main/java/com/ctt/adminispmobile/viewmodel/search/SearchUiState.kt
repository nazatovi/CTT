package com.ctt.adminispmobile.viewmodel.search

import com.ctt.adminispmobile.model.Suscriptor

data class SearchUiState(

    val textoBusqueda: String = "",

    val resultados: List<Suscriptor> = emptyList(),

    val loading: Boolean = false,

    val error: String? = null,

    val buscando: Boolean = false

)