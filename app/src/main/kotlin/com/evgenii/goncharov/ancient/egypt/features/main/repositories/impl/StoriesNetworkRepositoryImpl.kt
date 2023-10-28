package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.LinkStoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.PartStoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.StoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesDtoToStoriesEntityMapper
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesDtoToStoriesModelMapper
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesDtoToStoriesPartsEntityMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.request.StoriesModelRequest
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.StoriesApi
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesNetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StoriesNetworkRepositoryImpl @Inject constructor(
    private val storiesApi: StoriesApi,
    private val storiesDao: StoriesDao,
    private val partStoriesDao: PartStoriesDao,
    private val lingStoriesDao: LinkStoriesDao,
    private val storiesDtoToStoriesEntityMapper: StoriesDtoToStoriesEntityMapper,
    private val storiesDtoToStoriesModelMapper: StoriesDtoToStoriesModelMapper,
    private val storiesDtoToStoriesPartsEntityMapper: StoriesDtoToStoriesPartsEntityMapper
) : StoriesNetworkRepository {

    override suspend fun invoke(modelRequest: StoriesModelRequest): BaseStatusModel<StoriesModel> {
        val response = storiesApi.getStories(modelRequest)
        updateStoriesToDatabase(response.data)
        return storiesDtoToStoriesModelMapper(response)
    }

    private suspend fun updateStoriesToDatabase(dto: StoriesDto?) = withContext(Dispatchers.IO) {
        dto?.let {
            storiesDao.insertStories(storiesDtoToStoriesEntityMapper(dto))
            partStoriesDao.insertStoriesEntity(storiesDtoToStoriesPartsEntityMapper(dto))
        }
    }
}