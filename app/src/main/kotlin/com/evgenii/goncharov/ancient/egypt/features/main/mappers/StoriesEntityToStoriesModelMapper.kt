package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel
import javax.inject.Inject

class StoriesEntityToStoriesModelMapper @Inject constructor() {

    operator fun invoke(entities: List<StoriesEntity>): List<MainStoriesModel> {
        return entities.map { entity ->
            MainStoriesModel(
                id = entity.id,
                storiesImage = entity.storiesImage,
                storiesTitle = entity.storiesTitle
            )
        }
    }
}