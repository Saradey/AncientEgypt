package com.evgenii.goncharov.ancient.egypt.core

import android.os.Build
import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.splash.navigation.SplashScreens
import com.evgenii.goncharov.ancient.egypt.use.cases.OnboardingUseCase
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
    private val onboardingUseCase: OnboardingUseCase
) : ViewModel() {

    fun startFirstScreen() {
//        when {
//            isStartOnboarding() -> activityRouter.navigateTo(SplashScreens.startOnboarding())
//        }
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            if (onboardingRepository.isFirstStartOnboarding()) {
//                activityRouter.navigateTo(MainScreens.startMainBottomMenu())
//            } else {
//                activityRouter.navigateTo(SplashScreens.startOnboarding())
//            }
//        } else {
//            activityRouter.navigateTo(SplashScreens.startSplash())
//        }
    }

//    private fun isStartOnboarding(): Boolean {
//        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && onboardingRepository.isFirstStartOnboarding()
//    }
}