package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.ContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.BannerDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.MapInfoDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.MapInfoEntity
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.BannerDtoToBannerEntityMapper
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.ContentMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.ContentDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.ContentFromNetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ContentFromNetworkRepositoryImpl @Inject constructor(
    private val mainContentApi: ContentApi,
    private val mainContentMapper: ContentMapper,
    private val bannerDao: BannerDao,
    private val bannerDtoToBannerEntityMapper: BannerDtoToBannerEntityMapper,
    private val mapInfoDao: MapInfoDao
) : ContentFromNetworkRepository {

    override suspend fun invoke(): BaseStatusModel<ContentModel> {
        val response = mainContentApi.getMainContent()
        response.data?.let { insertNewContentToDb(it) }
        return mainContentMapper(response)
    }

    private suspend fun insertNewContentToDb(dto: ContentDto) = withContext(Dispatchers.IO) {
        bannerDao.insertBanner(bannerDtoToBannerEntityMapper(dto.content))
        mapInfoDao.insertMapInfoEntity(MapInfoEntity(dto.isEnabledMap))
    }
}