package com.evgenii.goncharov.ancient.egypt.base.models.rest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<out T>(
    @SerialName("status") val status: String,
    @SerialName("message") val message: String,
    @SerialName("data") val data: T?
)