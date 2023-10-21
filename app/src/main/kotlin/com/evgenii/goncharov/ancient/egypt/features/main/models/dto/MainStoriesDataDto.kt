package com.evgenii.goncharov.ancient.egypt.features.main.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainStoriesDataDto(
    @SerialName("stories") val stories: List<MainStoriesDto>
)
