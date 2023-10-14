package com.evgenii.goncharov.ancient.egypt.features.main.models.state

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel

sealed interface StoriesUiState {

    data object Loading : StoriesUiState

    data object HideStories : StoriesUiState

    data object Error : StoriesUiState

    data class Stories(val models: List<StoriesModel>): StoriesUiState
}