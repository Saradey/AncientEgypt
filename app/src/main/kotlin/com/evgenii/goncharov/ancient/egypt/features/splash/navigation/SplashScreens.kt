package com.evgenii.goncharov.ancient.egypt.features.splash.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgenii.goncharov.ancient.egypt.features.splash.OnboardingFragment
import com.evgenii.goncharov.ancient.egypt.features.splash.SplashFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object SplashScreens {

    fun startSplash() = object : FragmentScreen {
        override val screenKey: String = ""
        override fun createFragment(factory: FragmentFactory): Fragment {
            return SplashFragment.newInstance()
        }
    }

    fun startOnboarding() = object : FragmentScreen {
        override val screenKey: String = ""
        override fun createFragment(factory: FragmentFactory): Fragment {
            return OnboardingFragment.newInstance()
        }
    }
}