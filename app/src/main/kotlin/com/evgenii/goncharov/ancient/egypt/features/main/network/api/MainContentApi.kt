package com.evgenii.goncharov.ancient.egypt.features.main.network.api

import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.MainContentDto

interface MainContentApi {

    suspend fun getMainContent() : BaseDto<MainContentDto>
}