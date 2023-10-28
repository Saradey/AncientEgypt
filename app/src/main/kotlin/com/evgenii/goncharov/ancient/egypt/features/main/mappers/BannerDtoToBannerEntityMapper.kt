package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.BannerEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.BannerDto
import javax.inject.Inject

class BannerDtoToBannerEntityMapper @Inject constructor() {

    operator fun invoke(content: List<BannerDto>): List<BannerEntity> {
        return content.map { dto ->
            BannerEntity(
                bannerId = dto.id,
                contentType = dto.contentType,
                bannerTitle = dto.title,
                bannerUri = dto.bannerUri,
                bannerDescription = dto.description
            )
        }
    }
}