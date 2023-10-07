package com.evgenii.goncharov.ancient.egypt.features.main.rest.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BannerResponse(
    @SerialName("id") val id: String,
    @SerialName("contentType") val contentType: String,
    @SerialName("title") val title: String,
    @SerialName("bannerUri") val bannerUri: String,
    @SerialName("description") val description: String?
)