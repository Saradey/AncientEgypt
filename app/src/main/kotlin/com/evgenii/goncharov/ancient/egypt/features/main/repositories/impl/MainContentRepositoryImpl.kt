package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.features.main.api.MainContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.models.entities.ContentEntity
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentRepository
import javax.inject.Inject

class MainContentRepositoryImpl @Inject constructor(
    private val mainContentApi: MainContentApi
) : MainContentRepository {

    override suspend fun getContentScreen(): List<ContentEntity> {
        return emptyList()
    }
}