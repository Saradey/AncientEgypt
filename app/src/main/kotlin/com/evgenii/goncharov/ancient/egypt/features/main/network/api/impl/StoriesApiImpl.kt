package com.evgenii.goncharov.ancient.egypt.features.main.network.api.impl

import android.content.Context
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseResponseDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDataDto
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.StoriesApi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import javax.inject.Inject

class StoriesApiImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : StoriesApi {

    override suspend fun getStories(): BaseResponseDto<StoriesDataDto> {
        val rawResponse = context.resources.openRawResource(getResponse(0))
        val stringResponse = rawResponse.bufferedReader().use { it.readText() }
        delay(1000)
        return Json.decodeFromString(stringResponse)
    }

    private fun getResponse(response: Int): Int {
        return when (response) {
            0 -> R.raw.stories_response_success
            else -> R.raw.stories_response_success
        }
    }
}