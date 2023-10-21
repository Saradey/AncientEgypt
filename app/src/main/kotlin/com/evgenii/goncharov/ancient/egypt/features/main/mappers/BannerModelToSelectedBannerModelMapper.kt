package com.evgenii.goncharov.ancient.egypt.features.main.mappers

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BannerModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedBannerModel

object BannerModelToSelectedBannerModelMapper {

    fun mapBannerModelToSelectedBannerModel(model : BannerModel) : SelectedBannerModel  {
        return SelectedBannerModel(
            id = model.id,
            contentType = model.contentType
        )
    }
}