package com.evgenii.goncharov.ancient.egypt.features.main.use.cases

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel

fun interface ContentDatabaseUseCase {

    suspend operator fun invoke() : BaseModel<ContentModel>
}