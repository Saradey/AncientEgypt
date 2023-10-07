package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.entities.BaseEntity
import com.evgenii.goncharov.ancient.egypt.features.main.api.MainContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.MainContentMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentRepository
import javax.inject.Inject

class MainContentRepositoryImpl @Inject constructor(
    private val mainContentApi: MainContentApi,
    private val mainContentMapper: MainContentMapper
) : MainContentRepository {

    override suspend fun invoke(): BaseEntity<ContentModel> {
        val response = mainContentApi.getMainContent()

        return mainContentMapper(response)
    }
}