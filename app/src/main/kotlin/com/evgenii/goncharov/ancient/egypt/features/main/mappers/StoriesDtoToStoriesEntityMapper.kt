package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.MainStoriesDto
import javax.inject.Inject

class StoriesDtoToStoriesEntityMapper @Inject constructor() {

    operator fun invoke(dto: List<MainStoriesDto>) : List<StoriesEntity> {
        return dto.map { storiesDto ->
            StoriesEntity(
                storiesDto.id,
                storiesDto.storiesImage,
                storiesDto.storiesTitle.orEmpty()
            )
        }
    }
}