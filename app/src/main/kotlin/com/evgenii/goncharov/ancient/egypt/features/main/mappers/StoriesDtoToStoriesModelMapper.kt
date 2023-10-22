package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseResponseDto
import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus
import com.evgenii.goncharov.ancient.egypt.consts.mapContentType
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import javax.inject.Inject

class StoriesDtoToStoriesModelMapper @Inject constructor() {

    operator fun invoke(response: BaseResponseDto<StoriesDto>) : BaseStatusModel<StoriesModel> {
        return BaseStatusModel(
            status = ResponseStatus.valueOf(response.status.uppercase()),
            message = response.message.orEmpty(),
            data = mapStoriesDtoToStoriesModel(response.data)
        )
    }

    private fun mapStoriesDtoToStoriesModel(dto: StoriesDto?) : StoriesModel? {
        return dto?.let {
            StoriesModel(
                id = dto.id,
                type = dto.type,
                title = dto.title,
                description = dto.description,
                titleColor = dto.titleColor,
                descriptionColor = dto.descriptionColor,
                uriContent = dto.uri,
                linkId = dto.link?.id,
                linkType = mapContentType(dto.link?.type)
            )
        }
    }
}