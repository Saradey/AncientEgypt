package com.evgenii.goncharov.ancient.egypt.features.main.api.impl

import com.evgenii.goncharov.ancient.egypt.base.models.rest.BaseResponse
import com.evgenii.goncharov.ancient.egypt.features.main.api.MainContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.models.rest.MainContentResponse
import javax.inject.Inject

class MainContentApiImpl @Inject constructor() : MainContentApi {

    override suspend fun getMainContent(): BaseResponse<MainContentResponse> {
        TODO("Not yet implemented")
    }
}