package com.evgenii.goncharov.ancient.egypt.features.main.api.impl

import android.content.Context
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.models.rest.BaseResponse
import com.evgenii.goncharov.ancient.egypt.features.main.api.MainContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.MainContentDto
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import javax.inject.Inject

class MainContentApiImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : MainContentApi {

    override suspend fun getMainContent(): BaseResponse<MainContentDto> {
        val rawResponse = context.resources.openRawResource(getResponse(1))
        val stringResponse = rawResponse.bufferedReader().use { it.readText() }
        delay(1000)
        return Json.decodeFromString(stringResponse)
    }

    private fun getResponse(response: Int): Int {
        return when (response) {
            0 -> R.raw.main_content_response_1_success
            1 -> R.raw.main_content_response_2_error
            else -> R.raw.main_content_response_1_success
        }
    }
}