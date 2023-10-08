package com.evgenii.goncharov.ancient.egypt.features.main.repositories

import com.evgenii.goncharov.ancient.egypt.base.models.model.FromNetworkBaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel

interface MainContentFromNetworkRepository {

    suspend operator fun invoke(): FromNetworkBaseModel<ContentModel>
}