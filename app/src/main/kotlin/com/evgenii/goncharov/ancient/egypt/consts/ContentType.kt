package com.evgenii.goncharov.ancient.egypt.consts

enum class ContentType {
    CATEGORY,
    ARTICLE,
    ARTICLE_MAP,
    ARTIFACT
}

fun mapContentType(type: String?) : ContentType? {
    return type?.let {
        ContentType.valueOf(type.uppercase())
    }
}