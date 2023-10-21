package com.evgenii.goncharov.ancient.egypt.features.main.network.api.impl

import android.content.Context
import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseResponseDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.request.StoriesModelRequest
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.StoriesApi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StoriesApiImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : StoriesApi {

    override suspend fun getStories(modelRequest: StoriesModelRequest): BaseResponseDto<Nothing> {
        TODO("Not yet implemented")
    }
}