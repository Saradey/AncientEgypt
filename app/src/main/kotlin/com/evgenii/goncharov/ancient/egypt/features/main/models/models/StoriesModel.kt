package com.evgenii.goncharov.ancient.egypt.features.main.models.models

import com.evgenii.goncharov.ancient.egypt.consts.ContentType

data class StoriesModel(
    val id: String,
    val type: String,
    val title: String?,
    val description: String?,
    val titleColor: Long?,
    val descriptionColor: Long?,
    val uriContent: String,
    val linkId: String?,
    val linkType: ContentType?
)