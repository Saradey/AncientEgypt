package com.evgenii.goncharov.ancient.egypt.features.main.use.cases

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel

fun interface StoriesNetworkUseCase {

    suspend operator fun invoke() : BaseStatusModel<StoriesModel>
}