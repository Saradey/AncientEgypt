package com.evgenii.goncharov.ancient.egypt.features.splash.navigation

import com.evgenii.goncharov.ancient.egypt.features.splash.OnboardingFragment
import com.evgenii.goncharov.ancient.egypt.features.splash.SplashFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object SplashScreens {

    fun startSplash() = FragmentScreen { _ ->
        SplashFragment.newInstance()
    }

    fun startOnboarding() = FragmentScreen { _ ->
        OnboardingFragment.newInstance()
    }
}