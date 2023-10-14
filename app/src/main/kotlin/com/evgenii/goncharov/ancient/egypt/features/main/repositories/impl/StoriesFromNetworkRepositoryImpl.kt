package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.StoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesDtoToStoriesModelMapper
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesDtoToStoriesEntityMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.StoriesApi
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesFromNetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StoriesFromNetworkRepositoryImpl @Inject constructor(
    private val storiesApi: StoriesApi,
    private val storiesDtoToStoriesModelMapper: StoriesDtoToStoriesModelMapper,
    private val storiesDao: StoriesDao,
    private val storiesDtoTpStoriesEntityMapper: StoriesDtoToStoriesEntityMapper
) : StoriesFromNetworkRepository {

    override suspend fun invoke(): BaseStatusModel<List<StoriesModel>> {
        val response = storiesApi.getStories()
        updateStoriesToDatabase(response.data?.stories)
        return storiesDtoToStoriesModelMapper(response)
    }

    private suspend fun updateStoriesToDatabase(dto: List<StoriesDto>?) =
        withContext(Dispatchers.IO) {
            storiesDao.insertStories(storiesDtoTpStoriesEntityMapper(dto ?: emptyList()))
        }
}