package com.evgenii.goncharov.ancient.egypt.features.main.models.models

import com.evgenii.goncharov.ancient.egypt.features.main.models.consts.StoriesContentType

data class PartStoriesModel(
    val title: String?,
    val description: String?,
    val titleColor: Long?,
    val descriptionColor: Long?,
    val uriContent: String,
    val type: StoriesContentType
)