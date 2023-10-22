package com.evgenii.goncharov.ancient.egypt.features.main.models.models

data class StoriesModel(
    val id: String,
    val parts: List<PartStoriesModel>,
    val link: LinkStories?
)