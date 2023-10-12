package com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.ContentFromNetworkRepository
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.ContentFromNetworkUseCase
import javax.inject.Inject

class ContentFromNetworkUseCaseImpl @Inject constructor(
    private val mainContentRepository: ContentFromNetworkRepository
) : ContentFromNetworkUseCase {

    override suspend fun invoke(): BaseStatusModel<ContentModel> {
        return mainContentRepository()
    }
}