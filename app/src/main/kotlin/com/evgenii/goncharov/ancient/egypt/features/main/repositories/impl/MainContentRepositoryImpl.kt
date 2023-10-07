package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.entities.BaseEntity
import com.evgenii.goncharov.ancient.egypt.features.main.api.MainContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.BannerDao
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.BannerDtoToBannerEntityMapper
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.MainContentMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.MainContentDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainContentRepositoryImpl @Inject constructor(
    private val mainContentApi: MainContentApi,
    private val mainContentMapper: MainContentMapper,
    private val bannerDao: BannerDao,
    private val bannerDtoToBannerEntityMapper: BannerDtoToBannerEntityMapper
) : MainContentRepository {

    override suspend fun invoke(): BaseEntity<ContentModel> {
        val response = mainContentApi.getMainContent()
        response.data?.let { insertNewContentToDb(it) }
        return mainContentMapper(response)
    }

    private suspend fun insertNewContentToDb(dto: MainContentDto) = withContext(Dispatchers.IO) {
        bannerDao.insertBanner(bannerDtoToBannerEntityMapper(dto.content))
    }
}