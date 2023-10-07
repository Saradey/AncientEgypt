package com.evgenii.goncharov.ancient.egypt.features.main.ui

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BaseContentModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainContentAdapter(
    mapClickListener: () -> Unit
) : ListDelegationAdapter<List<BaseContentModel>>(
    mapButtonDelegate(mapClickListener)
)