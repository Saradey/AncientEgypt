package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.consts.mapContentType
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import javax.inject.Inject

class StoriesEntityToStoriesModelMapper @Inject constructor() {

    operator fun invoke(entity: StoriesEntity) : StoriesModel {
        return StoriesModel(
            id = entity.id,
            type = entity.type,
            title = entity.title,
            description = entity.description,
            titleColor = entity.titleColor,
            descriptionColor = entity.descriptionColor,
            uriContent = entity.uriContent,
            linkId = entity.linkId,
            linkType = mapContentType(entity.linkType)
        )
    }
}