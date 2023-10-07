package com.evgenii.goncharov.ancient.egypt.features.main.use.cases

import com.evgenii.goncharov.ancient.egypt.base.models.entities.BaseEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel

interface MainContentUseCase {

    suspend operator fun invoke() : BaseEntity<ContentModel>
}