package com.evgenii.goncharov.ancient.egypt.features.main.models.rest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainContentResponse(
    @SerialName("isEnabledMap") val isEnabledMap: Boolean,
    @SerialName("content") val content: List<BannerResponse>
)