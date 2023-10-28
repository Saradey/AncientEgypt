package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseResponseDto
import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus
import com.evgenii.goncharov.ancient.egypt.consts.mapContentType
import com.evgenii.goncharov.ancient.egypt.features.main.models.consts.mapStoriesContentType
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.PartStoriesDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesLinkDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.LinkStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.PartStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import javax.inject.Inject

class StoriesDtoToStoriesModelMapper @Inject constructor() {

    operator fun invoke(response: BaseResponseDto<StoriesDto>) : BaseStatusModel<StoriesModel> {
        return BaseStatusModel(
            status = ResponseStatus.valueOf(response.status.uppercase()),
            message = response.message,
            data = mapStoriesDtoToStoriesModel(response.data)
        )
    }

    private fun mapStoriesDtoToStoriesModel(dto: StoriesDto?) : StoriesModel? {
        return dto?.let {
            StoriesModel(
                id = dto.id,
                parts = partStoriesDtoToPartStoriesModel(dto.storiesPart),
                link = storiesLinkDtoToLinkStoriesModel(dto.link)
            )
        }
    }

    private fun partStoriesDtoToPartStoriesModel(storiesPart: List<PartStoriesDto>) : List<PartStoriesModel> {
        return storiesPart.map { dto ->
            PartStoriesModel(
                partsStoriesId = dto.partsStoriesId,
                title = dto.title,
                description = dto.description,
                titleColor = dto.titleColor,
                descriptionColor = dto.descriptionColor,
                uriContent = dto.uri,
                type = mapStoriesContentType(dto.type)
            )
        }
    }

    private fun storiesLinkDtoToLinkStoriesModel(link: StoriesLinkDto?) : LinkStoriesModel? {
        return link?.let {
            LinkStoriesModel(
                linkId = link.id,
                linkType = mapContentType(link.type)
            )
        }
    }
}