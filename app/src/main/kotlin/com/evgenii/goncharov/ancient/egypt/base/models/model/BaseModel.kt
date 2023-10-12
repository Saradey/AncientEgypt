package com.evgenii.goncharov.ancient.egypt.base.models.model

data class BaseModel<out T>(
    val data: T
)