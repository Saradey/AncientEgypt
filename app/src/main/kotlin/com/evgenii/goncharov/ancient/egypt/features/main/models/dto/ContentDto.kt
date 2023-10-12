package com.evgenii.goncharov.ancient.egypt.features.main.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentDto(
    @SerialName("isEnabledMap") val isEnabledMap: Boolean,
    @SerialName("content") val content: List<BannerDto>
)