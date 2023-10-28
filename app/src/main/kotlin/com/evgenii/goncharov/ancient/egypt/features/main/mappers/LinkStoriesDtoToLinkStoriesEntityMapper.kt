package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.consts.mapContentType
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.LinkStoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDto
import javax.inject.Inject

class LinkStoriesDtoToLinkStoriesEntityMapper @Inject constructor() {

    operator fun invoke(dto: StoriesDto) : LinkStoriesEntity? {
        return dto.link?.let { linkDto ->
            LinkStoriesEntity(
                linkId = linkDto.id,
                linkType = mapContentType(linkDto.type),
                linkStoriesOwnerId = dto.id
            )
        }
    }
}