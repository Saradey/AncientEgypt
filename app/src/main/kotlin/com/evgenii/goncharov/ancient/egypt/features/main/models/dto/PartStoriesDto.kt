package com.evgenii.goncharov.ancient.egypt.features.main.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PartStoriesDto(
    @SerialName("title") val title: String? = null,
    @SerialName("uri_content") val uri: String,
    @SerialName("description") val description: String? = null,
    @SerialName("title_color") val titleColor: Long? = null,
    @SerialName("description_color") val descriptionColor: Long? = null,
    @SerialName("type") val type: String
)
