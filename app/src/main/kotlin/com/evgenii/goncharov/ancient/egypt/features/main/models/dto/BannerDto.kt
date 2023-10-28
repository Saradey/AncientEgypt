package com.evgenii.goncharov.ancient.egypt.features.main.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BannerDto(
    @SerialName("id") val id: String,
    @SerialName("content_type") val contentType: String,
    @SerialName("banner_uri") val bannerUri: String,
    @SerialName("description") val description: String? = null,
    @SerialName("title") val title: String? = null
)