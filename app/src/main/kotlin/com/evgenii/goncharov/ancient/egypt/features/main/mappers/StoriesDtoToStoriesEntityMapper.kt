package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDto
import javax.inject.Inject

class StoriesDtoToStoriesEntityMapper @Inject constructor() {

    operator fun invoke(dto: StoriesDto) : StoriesEntity {
        return StoriesEntity(
            storiesId = dto.id,
        )
    }
}