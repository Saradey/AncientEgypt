package com.evgenii.goncharov.ancient.egypt.features.splash.navigation

import com.evgenii.goncharov.ancient.egypt.features.splash.fragments.OnboardingFragment
import com.evgenii.goncharov.ancient.egypt.features.splash.fragments.SplashFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object SplashScreens {

    /**
     * Navigation activity container
     */
    fun startSplash() = FragmentScreen(
        key = SCREEN_KEY_SPLASH
    ) { _ ->
        SplashFragment.newInstance()
    }

    fun startOnboarding() = FragmentScreen(
        key = SCREEN_KEY_ONBOARDING
    ) { _ ->
        OnboardingFragment.newInstance()
    }

    private const val SCREEN_KEY_ONBOARDING = "onboarding_screen"
    private const val SCREEN_KEY_SPLASH = "splash_screen"
}