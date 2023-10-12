package com.evgenii.goncharov.ancient.egypt.features.main.use.cases

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel

interface ContentFromNetworkUseCase {

    suspend operator fun invoke() : BaseStatusModel<ContentModel>
}