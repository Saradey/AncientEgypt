package com.evgenii.goncharov.ancient.egypt.features.main.ui

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class StoriesAdapter(storiesClick: (SelectedStoriesModel) -> Unit) : ListDelegationAdapter<List<StoriesModel>>(
    storiesDelegate(storiesClick)
)