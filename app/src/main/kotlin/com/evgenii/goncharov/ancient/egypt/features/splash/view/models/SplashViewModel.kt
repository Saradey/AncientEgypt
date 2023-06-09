package com.evgenii.goncharov.ancient.egypt.features.splash.view.models

import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.splash.navigation.SplashScreens
import com.evgenii.goncharov.ancient.egypt.repositories.OnboardingRepository
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SplashViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
    private val onboardingRepository: OnboardingRepository
) : ViewModel() {

    fun navigationToNext() {
        when {
            isStartOnboarding() -> activityRouter.replaceScreen(SplashScreens.startOnboarding())
            else -> activityRouter.replaceScreen(MainScreens.startMainBottomMenu())
        }
    }

    private fun isStartOnboarding(): Boolean {
        return onboardingRepository.isFirstStartOnboarding()
    }
}