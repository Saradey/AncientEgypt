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
        delay(5000)
        return Json.decodeFromString(stringResponse)
    }

    private fun getResponse(response: Int): Int {
        return when (response) {
            0 -> R.raw.main_content_response_1_success
            1 -> R.raw.main_content_response_2_error
            2 -> R.raw.main_content_response_3_error_2
            else -> R.raw.main_content_response_1_success
        }
    }
}