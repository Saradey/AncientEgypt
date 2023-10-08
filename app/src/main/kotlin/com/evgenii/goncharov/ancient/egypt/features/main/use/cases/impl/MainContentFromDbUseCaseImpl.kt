package com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.FromDbBaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentFromDbRepository
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainContentFromDbUseCase
import javax.inject.Inject

class MainContentFromDbUseCaseImpl @Inject constructor(
    private val mainContentFromDbRepository: MainContentFromDbRepository
) : MainContentFromDbUseCase {

    override suspend fun invoke(): FromDbBaseModel<ContentModel> {
        return mainContentFromDbRepository()
    }
}
