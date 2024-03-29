package com.evgenii.goncharov.ancient.egypt.features.main.network.api.impl

import android.content.Context
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseResponseDto
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.ContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.ContentDto
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ContentApiImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ContentApi {

    override suspend fun getMainContent(): BaseResponseDto<ContentDto> {
        val rawResponse = context.resources.openRawResource(getResponse(0))
        val stringResponse = rawResponse.bufferedReader().use { it.readText() }
        delay(2000)
        return Json.decodeFromString(stringResponse)
    }

    private fun getResponse(response: Int): Int {
        return when (response) {
            0 -> R.raw.main_content_response_1_success
            1 -> R.raw.universal_error_response_with_message
            2 -> R.raw.universal_error_response
            3 -> R.raw.universal_broken_json_response
            4 -> R.raw.universal_empty_json
            else -> R.raw.main_content_response_1_success
        }
    }
}