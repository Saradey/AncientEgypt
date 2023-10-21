package com.evgenii.goncharov.ancient.egypt.features.main.network.api

import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseResponseDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.request.StoriesModelRequest

fun interface StoriesApi {

    suspend fun getStories(modelRequest: StoriesModelRequest) : BaseResponseDto<Nothing>
}