package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDto
import javax.inject.Inject

class StoriesDtoToStoriesEntityMapper @Inject constructor() {

    operator fun invoke(dto: StoriesDto) : StoriesEntity {
        return StoriesEntity(
            id = dto.id,
            type = dto.type,
            title = dto.title,
            description = dto.description,
            titleColor = dto.titleColor,
            descriptionColor = dto.descriptionColor,
            uriContent = dto.uri,
            linkId = dto.link?.id,
            linkType = dto.link?.type
        )
    }
}