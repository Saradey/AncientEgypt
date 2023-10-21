package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import javax.inject.Inject

class StoriesEntityToStoriesModelMapper @Inject constructor() {

    operator fun invoke(entities: List<StoriesEntity>): List<StoriesModel> {
        return entities.map { entity ->
            StoriesModel(
                id = entity.id,
                storiesImage = entity.storiesImage,
                storiesTitle = entity.storiesTitle
            )
        }
    }
}