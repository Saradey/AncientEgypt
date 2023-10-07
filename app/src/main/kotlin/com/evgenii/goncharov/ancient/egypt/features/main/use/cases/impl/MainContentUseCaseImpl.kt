package com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.base.models.entities.BaseEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentRepository
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainContentUseCase
import javax.inject.Inject

class MainContentUseCaseImpl @Inject constructor(
    private val mainContentRepository: MainContentRepository
) : MainContentUseCase {

    override suspend fun invoke(): BaseEntity<ContentModel> {
        return  mainContentRepository()
    }
}