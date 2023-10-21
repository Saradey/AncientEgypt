package com.evgenii.goncharov.ancient.egypt.features.main.ui

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BaseContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedBannerModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ContentAdapter(
    mapClickListener: () -> Unit,
    bannerClickListener: (model: SelectedBannerModel) -> Unit
) : ListDelegationAdapter<List<BaseContentModel>>(
    mapButtonDelegate(mapClickListener),
    bannerDelegate(bannerClickListener)
)