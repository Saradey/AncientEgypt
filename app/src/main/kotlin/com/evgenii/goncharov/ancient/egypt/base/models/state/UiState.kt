package com.evgenii.goncharov.ancient.egypt.base.models.state

sealed interface UiState{

    data class Success<out C>(val content: C) : UiState

    data object Loading : UiState

    data object Failure : UiState
}

