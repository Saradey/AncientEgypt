package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.FromDbBaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.BannerDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.MapInfoDao
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.BannerEntityToBannerModelMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentFromDbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainContentFromDbRepositoryImpl @Inject constructor(
    private val bannerDao: BannerDao,
    private val mapInfoDao: MapInfoDao,
    private val bannerEntityTpBannerModelMapper: BannerEntityToBannerModelMapper
) : MainContentFromDbRepository {

    override suspend fun invoke(): FromDbBaseModel<ContentModel> = withContext(Dispatchers.IO) {
        val banners = bannerDao.getAllBanners()
        val mapInfo = mapInfoDao.getMapInfo().firstOrNull()
        FromDbBaseModel(
            data = ContentModel(
                isEnabledMap = mapInfo?.isEnabledMap ?: false,
                content = bannerEntityTpBannerModelMapper(banners)
            )
        )
    }
}