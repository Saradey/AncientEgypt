package com.evgenii.goncharov.ancient.egypt.core

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.splash.navigation.SplashScreens
import com.evgenii.goncharov.ancient.egypt.navigation.MainActivityNavigator
import com.evgenii.goncharov.ancient.egypt.navigation.OnBackPressedActivityManager
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var navigatorHolder: NavigatorHolder
    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var router: Router
    @Inject lateinit var onBackPressed: OnBackPressedActivityManager
    private val navigator = MainActivityNavigator(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this, onBackPressed)
        savedInstanceState ?: if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (false) {
                router.navigateTo(MainScreens.startMainBottomMenu())
            } else {
                router.navigateTo(SplashScreens.startOnboarding())
            }
        } else {
            router.navigateTo(SplashScreens.startSplash())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}