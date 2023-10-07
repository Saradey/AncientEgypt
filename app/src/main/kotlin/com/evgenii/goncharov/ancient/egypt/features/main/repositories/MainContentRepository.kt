package com.evgenii.goncharov.ancient.egypt.features.main.repositories

import com.evgenii.goncharov.ancient.egypt.features.main.models.entities.ContentEntity

interface MainContentRepository {

    suspend fun getContentScreen(): List<ContentEntity>
}