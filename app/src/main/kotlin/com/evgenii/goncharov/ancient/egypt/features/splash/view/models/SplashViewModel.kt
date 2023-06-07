package com.evgenii.goncharov.ancient.egypt.features.splash.view.models

import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.splash.navigation.SplashScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SplashViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private var activityRouter: Router
) : ViewModel() {

    fun navigationToNext() {
        if (false) {
            goToTheMainBottomMenu()
        } else {
            goToTheOnboarding()
        }
    }

    private fun goToTheMainBottomMenu() {
        activityRouter.replaceScreen(MainScreens.startMainBottomMenu())
    }

    private fun goToTheOnboarding() {
        activityRouter.replaceScreen(SplashScreens.startOnboarding())
    }
}