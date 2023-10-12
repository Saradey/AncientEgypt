package com.evgenii.goncharov.ancient.egypt.features.main.network.api.impl

import android.content.Context
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseDto
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.MainContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.MainContentDto
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import javax.inject.Inject

class MainContentApiImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : MainContentApi {

    override suspend fun getMainContent(): BaseDto<MainContentDto> {
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