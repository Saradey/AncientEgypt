package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesDtoToStoriesModelMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.StoriesApi
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesFromNetworkRepository
import javax.inject.Inject

class StoriesFromNetworkRepositoryImpl @Inject constructor(
    private val storiesApi: StoriesApi,
    private val storiesDtoToStoriesModelMapper: StoriesDtoToStoriesModelMapper
) : StoriesFromNetworkRepository {

    override suspend fun invoke() : BaseStatusModel<List<StoriesModel>> {
        val response = storiesApi.getStories()
        return storiesDtoToStoriesModelMapper(response)
    }
}