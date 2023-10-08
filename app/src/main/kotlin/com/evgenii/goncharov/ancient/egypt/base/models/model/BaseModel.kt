package com.evgenii.goncharov.ancient.egypt.base.models.model

import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus

data class BaseModel<out T>(
    val status: ResponseStatus,
    val message: String,
    val data: T?
)