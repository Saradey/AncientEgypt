package com.evgenii.goncharov.ancient.egypt.core

import android.os.Build
import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.splash.navigation.SplashScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
) : ViewModel() {

    fun startFirstScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (false) {
                activityRouter.navigateTo(MainScreens.startMainBottomMenu())
            } else {
                activityRouter.navigateTo(SplashScreens.startOnboarding())
            }
        } else {
            activityRouter.navigateTo(SplashScreens.startSplash())
        }
    }
}