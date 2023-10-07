package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.features.main.models.entities.ContentEntity
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentRepository
import javax.inject.Inject

class MainContentRepositoryImpl @Inject constructor() : MainContentRepository {

    override suspend fun getContentScreen(): List<ContentEntity> {
        return emptyList()
    }
}