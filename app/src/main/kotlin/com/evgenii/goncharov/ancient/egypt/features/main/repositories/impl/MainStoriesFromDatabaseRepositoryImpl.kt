package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.StoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesEntityToStoriesModelMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainStoriesFromDatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainStoriesFromDatabaseRepositoryImpl @Inject constructor(
    private val storiesDao: StoriesDao,
    private val storiesEntityToStoriesModelMapper: StoriesEntityToStoriesModelMapper
) : MainStoriesFromDatabaseRepository {

    override suspend fun invoke(): BaseModel<List<MainStoriesModel>> = withContext(Dispatchers.IO) {
        val models = storiesEntityToStoriesModelMapper(storiesDao.getAllStories())
        BaseModel(
            data = models
        )
    }
}