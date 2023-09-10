package com.evgenii.goncharov.ancient.egypt.features.splash.repositories

import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.features.splash.models.OnboardingModel
import javax.inject.Inject

class OnboardingModelFactory @Inject constructor() {

    fun createModels(): List<OnboardingModel> {
        return listOf(
            OnboardingModel(R.string.onboarding_text_first, R.drawable.onboarding_first),
            OnboardingModel(R.string.onboarding_text_second, R.drawable.onboarding_second),
            OnboardingModel(R.string.onboarding_text_third, R.drawable.onboarding_third)
        )
    }
}