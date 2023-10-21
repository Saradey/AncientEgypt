package com.evgenii.goncharov.ancient.egypt.features.main.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainStoriesDto(
    @SerialName("id") val id: String,
    @SerialName("stories_image") val storiesImage: String,
    @SerialName("stories_title") val storiesTitle: String? = null
)