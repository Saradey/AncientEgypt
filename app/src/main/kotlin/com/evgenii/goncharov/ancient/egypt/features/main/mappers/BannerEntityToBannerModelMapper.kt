package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.BannerEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BannerModel
import javax.inject.Inject

class BannerEntityToBannerModelMapper @Inject constructor() {

    operator fun invoke(entities: List<BannerEntity>) : List<BannerModel> {
        return entities.map { entity ->
            BannerModel(
                id = entity.id,
                contentType = entity.contentType,
                title = entity.title,
                bannerUri = entity.bannerUri,
                description = entity.description.orEmpty()
            )
        }
    }
}