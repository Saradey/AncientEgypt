package com.evgenii.goncharov.ancient.egypt.features.main.repositories

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel

fun interface MainStoriesFromDatabaseRepository {

    suspend operator fun invoke(): BaseModel<List<MainStoriesModel>>
}