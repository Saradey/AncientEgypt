package com.evgenii.goncharov.ancient.egypt.features.main.repositories

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel

fun interface StoriesFromDatabaseRepository {

    suspend operator fun invoke(): BaseModel<List<StoriesModel>>
}