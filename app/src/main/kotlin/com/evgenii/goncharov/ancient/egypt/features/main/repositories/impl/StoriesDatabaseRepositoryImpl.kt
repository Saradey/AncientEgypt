package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.StoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.PartStoriesEntityToPartStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesDatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StoriesDatabaseRepositoryImpl @Inject constructor(
    private val storiesDao: StoriesDao,
    private val partStoriesEntityToPartStoriesModel: PartStoriesEntityToPartStoriesModel
) : StoriesDatabaseRepository {

    override suspend fun invoke(storiesId: String): BaseModel<StoriesModel> = withContext(
        Dispatchers.IO
    ) {
        BaseModel(
            data = StoriesModel(
                id = storiesId,
                parts = partStoriesEntityToPartStoriesModel(storiesDao.getStoriesWithPartStories(storiesId)),
                link = null
            )
        )
    }
}