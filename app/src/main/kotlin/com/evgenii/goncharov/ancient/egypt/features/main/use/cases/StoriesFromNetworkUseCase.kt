package com.evgenii.goncharov.ancient.egypt.features.main.use.cases

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel

fun interface StoriesFromNetworkUseCase {

    suspend operator fun invoke() : BaseStatusModel<List<MainStoriesModel>>
}