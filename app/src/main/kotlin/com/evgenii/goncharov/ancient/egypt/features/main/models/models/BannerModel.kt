package com.evgenii.goncharov.ancient.egypt.features.main.models.models

import com.evgenii.goncharov.ancient.egypt.consts.ContentType

data class BannerModel(
    val id: String,
    val contentType: ContentType,
    val title: String,
    val bannerUri: String,
    val description: String
) : BaseContentModel