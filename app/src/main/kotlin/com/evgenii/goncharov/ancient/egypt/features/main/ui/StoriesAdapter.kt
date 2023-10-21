package com.evgenii.goncharov.ancient.egypt.features.main.ui

import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class StoriesAdapter(storiesClick: (SelectedStoriesModel) -> Unit) : ListDelegationAdapter<List<MainStoriesModel>>(
    storiesDelegate(storiesClick)
)