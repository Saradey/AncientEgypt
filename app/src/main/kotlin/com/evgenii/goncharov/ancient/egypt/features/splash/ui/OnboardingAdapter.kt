package com.evgenii.goncharov.ancient.egypt.features.splash.ui

import com.evgenii.goncharov.ancient.egypt.features.splash.models.OnboardingModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class OnboardingAdapter : ListDelegationAdapter<List<OnboardingModel>>(
    onboardingDelegate()
)