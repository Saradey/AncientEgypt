package com.evgenii.goncharov.ancient.egypt.base.models.model

data class FromDbBaseModel<out T>(
    val data: T
)