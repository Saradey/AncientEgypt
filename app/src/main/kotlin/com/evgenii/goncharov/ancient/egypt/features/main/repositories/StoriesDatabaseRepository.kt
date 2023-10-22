package com.evgenii.goncharov.ancient.egypt.features.main.repositories

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel

interface StoriesDatabaseRepository {

    suspend operator fun invoke(storiesId: String) : BaseModel<StoriesModel>
}