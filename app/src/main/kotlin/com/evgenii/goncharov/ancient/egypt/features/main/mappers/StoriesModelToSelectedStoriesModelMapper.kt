package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel

object StoriesModelToSelectedStoriesModelMapper {

    fun mapStoriesModelToSelectedStoriesModel(
        selectedItem: StoriesModel,
        items: List<*>
    ): SelectedStoriesModel {
        return SelectedStoriesModel(
            selectedStoriesId = selectedItem.id,
            allStoriesId = items.filterIsInstance<StoriesModel>()
                .filter { storiesModel ->
                    storiesModel.id != selectedItem.id
                }
                .map { storiesModel ->
                    (storiesModel as StoriesModel).id
                }
        )
    }
}