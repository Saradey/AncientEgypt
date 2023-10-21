package com.evgenii.goncharov.ancient.egypt.features.main.models.state

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel

sealed interface StoriesUiState {

    data object Loading : StoriesUiState

    data object HideStories : StoriesUiState

    data object Error : StoriesUiState

    data class Stories(val models: List<MainStoriesModel>): StoriesUiState
}