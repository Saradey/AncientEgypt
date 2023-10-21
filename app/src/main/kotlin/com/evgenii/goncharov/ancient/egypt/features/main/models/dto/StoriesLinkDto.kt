package com.evgenii.goncharov.ancient.egypt.features.main.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoriesLinkDto(
    @SerialName("link_id") val id: String,
    @SerialName("link_type") val type: String
)
