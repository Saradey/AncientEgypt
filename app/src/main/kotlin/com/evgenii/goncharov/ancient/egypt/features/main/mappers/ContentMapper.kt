package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseResponseDto
import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus
import com.evgenii.goncharov.ancient.egypt.consts.mapContentType
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BannerModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.BannerDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.ContentDto
import javax.inject.Inject

class ContentMapper @Inject constructor() {

    operator fun invoke(response: BaseResponseDto<ContentDto>): BaseStatusModel<ContentModel> {
        return BaseStatusModel(
            status = ResponseStatus.valueOf(response.status.uppercase()),
            message = response.message.orEmpty(),
            data = mapContentDtoToContentModel(response.data)
        )
    }

    private fun mapContentDtoToContentModel(response: ContentDto?): ContentModel? {
        return response?.let { mainContent ->
            ContentModel(
                isEnabledMap = mainContent.isEnabledMap,
                content = mapBannerModel(mainContent.content)
            )
        }
    }

    private fun mapBannerModel(content: List<BannerDto>): List<BannerModel> {
        return content.map { model ->
            BannerModel(
                id = model.id,
                contentType = mapContentType(model.contentType),
                title = model.title,
                bannerUri = model.bannerUri,
                description = model.description.orEmpty()
            )
        }
    }
}