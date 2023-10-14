package com.evgenii.goncharov.ancient.egypt.features.main.repositories

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel

fun interface StoriesFromNetworkRepository {

    suspend operator fun invoke() : BaseStatusModel<List<StoriesModel>>
}