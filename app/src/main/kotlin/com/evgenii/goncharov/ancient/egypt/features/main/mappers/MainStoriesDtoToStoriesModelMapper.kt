package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseResponseDto
import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.MainStoriesDataDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel
import javax.inject.Inject

class MainStoriesDtoToStoriesModelMapper @Inject constructor() {

    operator fun invoke(response: BaseResponseDto<MainStoriesDataDto>): BaseStatusModel<List<MainStoriesModel>> {
        return BaseStatusModel(
            status = ResponseStatus.valueOf(response.status.uppercase()),
            message = response.message,
            data = mapStoriesDtoToStoriesModel(response.data)
        )
    }

    private fun mapStoriesDtoToStoriesModel(response: MainStoriesDataDto?): List<MainStoriesModel>? {
        return response?.stories?.map { dto ->
            MainStoriesModel(
                id = dto.id,
                storiesImage = dto.storiesImage,
                storiesTitle = dto.storiesTitle
            )
        }
    }
}