package com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.FromNetworkBaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentFromNetworkRepository
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainContentFromNetworkUseCase
import javax.inject.Inject

class MainContentFromNetworkUseCaseImpl @Inject constructor(
    private val mainContentRepository: MainContentFromNetworkRepository
) : MainContentFromNetworkUseCase {

    override suspend fun invoke(): FromNetworkBaseModel<ContentModel> {
        return mainContentRepository()
    }
}