package com.evgenii.goncharov.ancient.egypt.features.main.models.state

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BaseContentModel

sealed interface MainContentUiState {

    data object Loading : MainContentUiState

    data class LoadingUpdateAndContentFromDb(val content: List<BaseContentModel>) : MainContentUiState

    data class Update(val isErrorStateBefore: Boolean) : MainContentUiState

    data class Error(val messageError: String? = null) : MainContentUiState

    data object ErrorUpdate : MainContentUiState

    data class Content(val content: List<BaseContentModel>) : MainContentUiState
}
