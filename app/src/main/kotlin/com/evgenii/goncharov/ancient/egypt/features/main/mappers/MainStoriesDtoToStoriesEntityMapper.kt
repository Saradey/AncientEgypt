package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.MainStoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.MainStoriesDto
import javax.inject.Inject

class MainStoriesDtoToStoriesEntityMapper @Inject constructor() {

    operator fun invoke(dto: List<MainStoriesDto>) : List<MainStoriesEntity> {
        return dto.map { storiesDto ->
            MainStoriesEntity(
                storiesDto.id,
                storiesDto.storiesImage,
                storiesDto.storiesTitle
            )
        }
    }
}