package com.evgenii.goncharov.ancient.egypt.base.models.state

sealed interface CommonUiState<C> {

    data object Loading : CommonUiState<Nothing>

    data object Error: CommonUiState<Nothing>

    data class Success<C>(val content: C) : CommonUiState<C>
}