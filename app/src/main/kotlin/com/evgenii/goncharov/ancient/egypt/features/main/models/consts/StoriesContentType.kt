package com.evgenii.goncharov.ancient.egypt.features.main.models.consts

enum class StoriesContentType {
    STATIC,
    DYNAMIC,
    NOTHING
}

fun mapStoriesContentType(type: String): StoriesContentType {
    return try {
        StoriesContentType.valueOf(type)
    } catch (exp: Exception) {
        StoriesContentType.NOTHING
    }
}