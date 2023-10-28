package com.evgenii.goncharov.ancient.egypt.features.main.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PartStoriesDto(
    @SerialName("parts_stories_id") val partsStoriesId: String,
    @SerialName("title") val title: String?,
    @SerialName("uri_content") val uri: String,
    @SerialName("description") val description: String?,
    @SerialName("title_color") val titleColor: Long?,
    @SerialName("description_color") val descriptionColor: Long?,
    @SerialName("type") val type: String
)
