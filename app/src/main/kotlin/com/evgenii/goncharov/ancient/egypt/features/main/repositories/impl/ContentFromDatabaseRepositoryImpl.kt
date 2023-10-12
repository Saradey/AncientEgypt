package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.BannerDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.MapInfoDao
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.BannerEntityToBannerModelMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.ContentFromDatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ContentFromDatabaseRepositoryImpl @Inject constructor(
    private val bannerDao: BannerDao,
    private val mapInfoDao: MapInfoDao,
    private val bannerEntityTpBannerModelMapper: BannerEntityToBannerModelMapper
) : ContentFromDatabaseRepository {

    override suspend fun invoke(): BaseModel<ContentModel> = withContext(Dispatchers.IO) {
        val banners = bannerDao.getAllBanners()
        val mapInfo = mapInfoDao.getMapInfo().firstOrNull()
        BaseModel(
            data = ContentModel(
                isEnabledMap = mapInfo?.isEnabledMap ?: false,
                content = bannerEntityTpBannerModelMapper(banners)
            )
        )
    }
}