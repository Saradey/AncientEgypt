package com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainStoriesFromDatabaseRepository
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainStoriesDatabaseUseCase
import javax.inject.Inject

class StoriesFromDatabaseUseCaseImpl @Inject constructor(
    private val storiesFromDatabaseRepository: MainStoriesFromDatabaseRepository
) : MainStoriesDatabaseUseCase {

    override suspend fun invoke(): BaseModel<List<MainStoriesModel>> {
        return storiesFromDatabaseRepository()
    }
}