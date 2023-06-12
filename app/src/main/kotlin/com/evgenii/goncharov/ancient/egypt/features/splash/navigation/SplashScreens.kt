package com.evgenii.goncharov.ancient.egypt.features.splash.navigation

import com.evgenii.goncharov.ancient.egypt.features.splash.fragments.OnboardingFragment
import com.evgenii.goncharov.ancient.egypt.features.splash.fragments.SplashFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object SplashScreens {

    /**
     * Navigation activity container
     */
    fun startSplash() = FragmentScreen(
        key = BACKSTACK_NAME_SPLASH
    ) {
        SplashFragment.newInstance()
    }

    fun startOnboarding() = FragmentScreen(
        key = BACKSTACK_NAME_ONBOARDING
    ) {
        OnboardingFragment.newInstance()
    }

    private const val BACKSTACK_NAME_ONBOARDING = "onboarding"
    private const val BACKSTACK_NAME_SPLASH = "splash"
}