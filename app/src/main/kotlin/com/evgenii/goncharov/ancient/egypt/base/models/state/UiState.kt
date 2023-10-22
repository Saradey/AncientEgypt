package com.evgenii.goncharov.ancient.egypt.base.models.state

sealed interface UiState<out C> {
    data class Success<out C>(val content: C) : UiState<C>
    data object Loading : UiState<Nothing>
    data object Failure : UiState<Nothing>
    data object Init : UiState<Nothing>
}

