package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.base.models.entities.BaseEntity
import com.evgenii.goncharov.ancient.egypt.base.models.rest.BaseResponse
import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BannerModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.BannerDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.MainContentDto
import javax.inject.Inject

class MainContentMapper @Inject constructor() {

    operator fun invoke(response: BaseResponse<MainContentDto>): BaseEntity<ContentModel> {
        return BaseEntity(
            status = ResponseStatus.valueOf(response.status.uppercase()),
            message = response.message,
            data = mapMainContentResponse(response.data)
        )
    }

    private fun mapMainContentResponse(response: MainContentDto?): ContentModel? {
        return response?.let { mainContent ->
            ContentModel(
                isEnabledMap = mainContent.isEnabledMap,
                content = mapBanner(mainContent.content)
            )
        }
    }

    private fun mapBanner(content: List<BannerDto>): List<BannerModel> {
        return content.map { model ->
            BannerModel(
                id = model.id,
                contentType = model.contentType,
                title = model.title,
                bannerUri = model.bannerUri,
                description = model.description.orEmpty()
            )
        }
    }
}