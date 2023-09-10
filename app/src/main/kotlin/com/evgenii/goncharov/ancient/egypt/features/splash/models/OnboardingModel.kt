package com.evgenii.goncharov.ancient.egypt.features.splash.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingModel(
    @StringRes val textDescription: Int,
    @DrawableRes val idImage: Int
)
