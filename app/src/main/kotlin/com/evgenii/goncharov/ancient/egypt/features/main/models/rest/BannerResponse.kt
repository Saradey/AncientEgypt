package com.evgenii.goncharov.ancient.egypt.features.main.models.rest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BannerResponse(
    @SerialName("id") val id: String,
    @SerialName("content_type") val contentType: String,
    @SerialName("title") val title: String,
    @SerialName("banner_uri") val bannerUri: String,
    @SerialName("description") val description: String? = null
)