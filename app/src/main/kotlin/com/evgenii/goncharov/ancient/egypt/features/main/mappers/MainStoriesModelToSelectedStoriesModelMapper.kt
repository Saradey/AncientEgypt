package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel

object MainStoriesModelToSelectedStoriesModelMapper {

    fun mapStoriesModelToSelectedStoriesModel(
        selectedItem: MainStoriesModel,
        items: List<*>
    ): SelectedStoriesModel {
        return SelectedStoriesModel(
            selectedStoriesId = selectedItem.id,
            allStoriesId = items.filterIsInstance<MainStoriesModel>()
                .filter { storiesModel ->
                    storiesModel.id != selectedItem.id
                }
                .map { storiesModel ->
                    (storiesModel as MainStoriesModel).id
                }
        )
    }
}