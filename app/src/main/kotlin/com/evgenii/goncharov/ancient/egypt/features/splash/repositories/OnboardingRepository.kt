package com.evgenii.goncharov.ancient.egypt.features.splash.repositories

interface OnboardingRepository {

    fun isFirstStartOnboarding(): Boolean

    fun onboardingFinish()
}