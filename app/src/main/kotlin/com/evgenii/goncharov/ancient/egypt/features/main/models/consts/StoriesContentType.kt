package com.evgenii.goncharov.ancient.egypt.features.main.models.consts

enum class StoriesContentType {
    STATIC,
    DYNAMIC
}

fun mapStoriesContentType(type: String): StoriesContentType {
    return StoriesContentType.valueOf(type.uppercase())
}