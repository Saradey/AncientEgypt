package com.evgenii.goncharov.ancient.egypt.features.main.api

import com.evgenii.goncharov.ancient.egypt.base.models.rest.BaseResponse
import com.evgenii.goncharov.ancient.egypt.features.main.models.rest.MainContentResponse

interface MainContentApi {

    suspend fun getMainContent() : BaseResponse<MainContentResponse>
}