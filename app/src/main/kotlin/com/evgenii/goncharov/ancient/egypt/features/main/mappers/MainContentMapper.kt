package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.base.models.entities.BaseEntity
import com.evgenii.goncharov.ancient.egypt.base.models.rest.BaseResponse
import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus
import com.evgenii.goncharov.ancient.egypt.features.main.models.entities.BannerEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.entities.ContentEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.rest.BannerResponse
import com.evgenii.goncharov.ancient.egypt.features.main.models.rest.MainContentResponse
import javax.inject.Inject

class MainContentMapper @Inject constructor() {

    operator fun invoke(response: BaseResponse<MainContentResponse>): BaseEntity<ContentEntity> {
        return BaseEntity(
            status = ResponseStatus.valueOf(response.status.uppercase()),
            message = response.message,
            data = mapMainContentResponse(response.data)
        )
    }

    private fun mapMainContentResponse(response: MainContentResponse?): ContentEntity? {
        return response?.let { mainContent ->
            ContentEntity(
                isEnabledMap = mainContent.isEnabledMap,
                content = mapBanner(mainContent.content)
            )
        }
    }

    private fun mapBanner(content: List<BannerResponse>): List<BannerEntity> {
        return content.map { model ->
            BannerEntity(
                id = model.id,
                contentType = model.contentType,
                title = model.title,
                bannerUri = model.bannerUri,
                description = model.description.orEmpty()
            )
        }
    }
}