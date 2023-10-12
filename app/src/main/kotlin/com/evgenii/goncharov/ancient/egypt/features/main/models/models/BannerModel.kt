package com.evgenii.goncharov.ancient.egypt.features.main.models.models

data class BannerModel(
    val id: String,
    val contentType: String,
    val title: String,
    val bannerUri: String,
    val description: String
) : BaseContentModel