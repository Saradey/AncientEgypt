package com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.ContentFromDatabaseRepository
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.ContentFromDatabaseUseCase
import javax.inject.Inject

class ContentFromDatabaseUseCaseImpl @Inject constructor(
    private val mainContentFromDbRepository: ContentFromDatabaseRepository
) : ContentFromDatabaseUseCase {

    override suspend fun invoke(): BaseModel<ContentModel> {
        return mainContentFromDbRepository()
    }
}
