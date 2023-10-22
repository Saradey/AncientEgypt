package com.evgenii.goncharov.ancient.egypt.features.main.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoriesDto(
    @SerialName("id") val id: String,
    @SerialName("stories_part") val storiesPart: List<PartStoriesDto>,
    @SerialName("link") val link: StoriesLinkDto?
)