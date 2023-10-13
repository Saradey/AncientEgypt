package com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl

import com.evgenii.goncharov.ancient.egypt.features.main.network.api.StoriesApi
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesFromNetworkRepository
import javax.inject.Inject

class StoriesFromNetworkRepositoryImpl @Inject constructor(
    private val storiesApi: StoriesApi
) : StoriesFromNetworkRepository {

    override suspend fun invoke() {

    }
}