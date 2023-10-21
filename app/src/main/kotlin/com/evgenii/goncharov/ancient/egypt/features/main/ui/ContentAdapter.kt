package com.evgenii.goncharov.ancient.egypt.features.main.ui

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BaseContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedBanner
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ContentAdapter(
    mapClickListener: () -> Unit,
    bannerClickListener: (model: SelectedBanner) -> Unit
) : ListDelegationAdapter<List<BaseContentModel>>(
    mapButtonDelegate(mapClickListener),
    bannerDelegate(bannerClickListener)
)