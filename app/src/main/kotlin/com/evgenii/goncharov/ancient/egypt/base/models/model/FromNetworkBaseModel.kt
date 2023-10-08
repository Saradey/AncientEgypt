package com.evgenii.goncharov.ancient.egypt.base.models.model

import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus

data class FromNetworkBaseModel<out T>(
    val status: ResponseStatus,
    val message: String,
    val data: T?
)