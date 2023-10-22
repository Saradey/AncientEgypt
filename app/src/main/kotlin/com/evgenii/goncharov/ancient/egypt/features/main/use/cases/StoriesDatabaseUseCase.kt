package com.evgenii.goncharov.ancient.egypt.features.main.use.cases

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel

interface StoriesDatabaseUseCase {

    suspend operator fun invoke(storiesId: String) : BaseModel<StoriesModel>
}