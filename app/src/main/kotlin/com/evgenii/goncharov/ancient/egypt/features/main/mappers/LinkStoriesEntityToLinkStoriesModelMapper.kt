package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.consts.mapContentType
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.LinkStoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.LinkStoriesModel
import javax.inject.Inject

class LinkStoriesEntityToLinkStoriesModelMapper @Inject constructor() {

    operator fun invoke(entity: LinkStoriesEntity?): LinkStoriesModel? {
        return entity?.let {
            LinkStoriesModel(
                linkId = entity.linkId,
                linkType = mapContentType(entity.linkType)
            )
        }
    }
}