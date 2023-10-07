package com.evgenii.goncharov.ancient.egypt.features.main.models.state

import com.evgenii.goncharov.ancient.egypt.features.main.models.entities.ContentEntity

sealed interface MainContentUiState

data object Loading : MainContentUiState

data object LoadingUpdate : MainContentUiState

data object Error : MainContentUiState

data object ErrorUpdate : MainContentUiState

data class Content(val content: ContentEntity) : MainContentUiState
