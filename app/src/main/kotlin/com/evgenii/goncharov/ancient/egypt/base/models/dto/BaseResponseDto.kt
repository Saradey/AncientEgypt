package com.evgenii.goncharov.ancient.egypt.base.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponseDto<out T>(
    @SerialName("status") val status: String,
    @SerialName("message") val message: String? = null,
    @SerialName("data") val data: T?
)