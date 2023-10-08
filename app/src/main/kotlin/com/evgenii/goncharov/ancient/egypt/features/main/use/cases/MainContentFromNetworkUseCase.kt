package com.evgenii.goncharov.ancient.egypt.features.main.use.cases

import com.evgenii.goncharov.ancient.egypt.base.models.model.FromNetworkBaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel

interface MainContentFromNetworkUseCase {

    suspend operator fun invoke() : FromNetworkBaseModel<ContentModel>
}