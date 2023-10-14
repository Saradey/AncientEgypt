package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.base.models.dto.BaseResponseDto
import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.StoriesDataDto
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import javax.inject.Inject

class StoriesDtoToStoriesModelMapper @Inject constructor() {

    operator fun invoke(response: BaseResponseDto<StoriesDataDto>): BaseStatusModel<List<StoriesModel>> {
        return BaseStatusModel(
            status = ResponseStatus.valueOf(response.status.uppercase()),
            message = response.message.orEmpty(),
            data = mapStoriesDtoToStoriesModel(response.data)
        )
    }

    private fun mapStoriesDtoToStoriesModel(response: StoriesDataDto?): List<StoriesModel>? {
        return response?.stories?.map { dto ->
            StoriesModel(
                id = dto.id,
                storiesImage = dto.storiesImage,
                storiesTitle = dto.storiesTitle.orEmpty()
            )
        }
    }
}