package com.evgenii.goncharov.ancient.egypt.features.main.ui

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class StoriesAdapter(storiesClick: (String) -> Unit) : ListDelegationAdapter<List<StoriesModel>>(
    storiesDelegate(storiesClick)
)