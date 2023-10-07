package com.evgenii.goncharov.ancient.egypt.base.models.entities

import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus

data class BaseEntity<out T>(
    val status: ResponseStatus,
    val message: String,
    val data: T?
)