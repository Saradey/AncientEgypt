package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.StoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.StoriesApi
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesNetworkRepository
import javax.inject.Inject

class StoriesNetworkRepositoryImpl @Inject constructor(
    private val storiesApi: StoriesApi,
    private val storiesDao: StoriesDao
) : StoriesNetworkRepository {

    override suspend fun invoke(): BaseStatusModel<StoriesModel> {
        TODO("Not yet implemented")
    }
}