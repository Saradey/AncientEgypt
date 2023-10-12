package com.evgenii.goncharov.ancient.egypt.features.main.models.state

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BaseContentModel

sealed interface ContentUiState {

    data object Loading : ContentUiState

    data class UpdateAndOldContent(val content: List<BaseContentModel>) : ContentUiState

    data class Update(val isErrorStateBefore: Boolean) : ContentUiState

    data class Error(val messageError: String? = null) : ContentUiState

    data object ErrorUpdate : ContentUiState

    data class Content(val content: List<BaseContentModel>) : ContentUiState
}
