package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.PartStoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.consts.mapStoriesContentType
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDto
import javax.inject.Inject

class StoriesDtoToStoriesPartsEntityMapper @Inject constructor() {

    operator fun invoke(dto: StoriesDto) : List<PartStoriesEntity> {
        return dto.storiesPart.map { partDto ->
            PartStoriesEntity(
                storiesOwnerId = dto.id,
                partsStoriesId = partDto.partsStoriesId,
                type = mapStoriesContentType(partDto.type),
                title = partDto.title,
                description = partDto.description,
                titleColor = partDto.titleColor,
                descriptionColor = partDto.descriptionColor,
                uriContent = partDto.uri
            )
        }
    }
}