package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.MainStoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.MainStoriesEntityToStoriesModelMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainStoriesFromDatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainStoriesFromDatabaseRepositoryImpl @Inject constructor(
    private val mainStoriesDao: MainStoriesDao,
    private val mainStoriesEntityToStoriesModelMapper: MainStoriesEntityToStoriesModelMapper
) : MainStoriesFromDatabaseRepository {

    override suspend fun invoke(): BaseModel<List<MainStoriesModel>> = withContext(Dispatchers.IO) {
        val models = mainStoriesEntityToStoriesModelMapper(mainStoriesDao.getAllStories())
        BaseModel(
            data = models
        )
    }
}