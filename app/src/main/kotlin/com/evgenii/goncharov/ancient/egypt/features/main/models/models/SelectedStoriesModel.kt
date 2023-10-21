package com.evgenii.goncharov.ancient.egypt.features.main.models.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SelectedStoriesModel(
    val selectedStoriesId: String,
    val allStoriesId: List<String>
) : Parcelable