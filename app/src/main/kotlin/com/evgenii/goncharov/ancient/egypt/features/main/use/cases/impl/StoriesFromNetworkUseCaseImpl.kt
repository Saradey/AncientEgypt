package com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainStoriesFromNetworkRepository
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainStoriesFromNetworkUseCase
import javax.inject.Inject

class StoriesFromNetworkUseCaseImpl @Inject constructor(
    private val storiesFromNetworkRepository: MainStoriesFromNetworkRepository
) : MainStoriesFromNetworkUseCase {

    override suspend operator fun invoke(): BaseStatusModel<List<MainStoriesModel>> {
        return storiesFromNetworkRepository()
    }
}