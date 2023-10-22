package com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.request.StoriesModelRequest
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesNetworkRepository
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesNetworkUseCase
import javax.inject.Inject

class StoriesNetworkUseCaseImpl @Inject constructor(
    private val storiesNetworkRepository: StoriesNetworkRepository
) : StoriesNetworkUseCase {

    override suspend fun invoke(modelRequest: StoriesModelRequest): BaseStatusModel<StoriesModel> {
        return storiesNetworkRepository(modelRequest)
    }
}