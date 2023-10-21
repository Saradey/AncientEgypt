package com.evgenii.goncharov.ancient.egypt.features.main.network.api.impl

import android.content.Context
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseResponseDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.request.StoriesModelRequest
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.StoriesApi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import javax.inject.Inject

class StoriesApiImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : StoriesApi {

    override suspend fun getStories(modelRequest: StoriesModelRequest): BaseResponseDto<StoriesDto> {
        val rawResponse = context.resources.openRawResource(getResponse(0))
        val stringResponse = rawResponse.bufferedReader().use { it.readText() }
        delay(1000)
        return Json.decodeFromString(stringResponse)
    }

    private fun getResponse(response: Int): Int {
        return when (response) {
            0 -> TODO()
            1 -> R.raw.universal_error_response
            2 -> R.raw.universal_broken_json_response
            3 -> R.raw.universal_empty_json
            4 -> R.raw.universal_error_response_with_message
            else -> R.raw.universal_broken_json_response
        }
    }
}