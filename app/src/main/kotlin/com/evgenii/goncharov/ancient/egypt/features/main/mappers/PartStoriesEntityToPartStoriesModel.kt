package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.db.dto.StoriesWithPartStories
import com.evgenii.goncharov.ancient.egypt.features.main.models.consts.mapStoriesContentType
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.PartStoriesModel
import javax.inject.Inject

class PartStoriesEntityToPartStoriesModel @Inject constructor() {

    operator fun invoke(storiesWithPartStories: StoriesWithPartStories) : List<PartStoriesModel> {
        return storiesWithPartStories.partsStories.map { partEntity ->
            PartStoriesModel(
                partsStoriesId = partEntity.partsStoriesId,
                title = partEntity.title,
                description = partEntity.description,
                titleColor = partEntity.titleColor,
                descriptionColor = partEntity.descriptionColor,
                uriContent = partEntity.uriContent,
                type = mapStoriesContentType(partEntity.type)
            )
        }
    }
}