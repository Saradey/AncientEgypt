package com.evgenii.goncharov.ancient.egypt.features.main.repositories

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel

interface ContentFromNetworkRepository {

    suspend operator fun invoke(): BaseStatusModel<ContentModel>
}