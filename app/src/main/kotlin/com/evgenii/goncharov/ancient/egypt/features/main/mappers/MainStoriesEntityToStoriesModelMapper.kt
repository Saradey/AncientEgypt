package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.MainStoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel
import javax.inject.Inject

class MainStoriesEntityToStoriesModelMapper @Inject constructor() {

    operator fun invoke(entities: List<MainStoriesEntity>): List<MainStoriesModel> {
        return entities.map { entity ->
            MainStoriesModel(
                id = entity.id,
                storiesImage = entity.storiesImage,
                storiesTitle = entity.storiesTitle
            )
        }
    }
}