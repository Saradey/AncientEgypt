package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.StoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesEntityToStoriesModelMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesFromDatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StoriesFromDatabaseRepositoryImpl @Inject constructor(
    private val storiesDao: StoriesDao,
    private val storiesEntityToStoriesModelMapper: StoriesEntityToStoriesModelMapper
) : StoriesFromDatabaseRepository {

    override suspend fun invoke(): BaseModel<List<StoriesModel>> = withContext(Dispatchers.IO) {
        val models = storiesEntityToStoriesModelMapper(storiesDao.getAllStories())
        BaseModel(
            data = models
        )
    }
}