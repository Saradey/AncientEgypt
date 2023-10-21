package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.StoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesDtoToStoriesModelMapper
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesDtoToStoriesEntityMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.MainStoriesDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.MainScreenStoriesApi
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainStoriesFromNetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainStoriesFromNetworkRepositoryImpl @Inject constructor(
    private val storiesApi: MainScreenStoriesApi,
    private val storiesDtoToStoriesModelMapper: StoriesDtoToStoriesModelMapper,
    private val storiesDao: StoriesDao,
    private val storiesDtoTpStoriesEntityMapper: StoriesDtoToStoriesEntityMapper
) : MainStoriesFromNetworkRepository {

    override suspend fun invoke(): BaseStatusModel<List<StoriesModel>> {
        val response = storiesApi.getStories()
        updateStoriesToDatabase(response.data?.stories)
        return storiesDtoToStoriesModelMapper(response)
    }

    private suspend fun updateStoriesToDatabase(dto: List<MainStoriesDto>?) =
        withContext(Dispatchers.IO) {
            storiesDao.insertStories(storiesDtoTpStoriesEntityMapper(dto ?: emptyList()))
        }
}