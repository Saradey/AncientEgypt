package com.evgenii.goncharov.ancient.egypt

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.splash.navigation.SplashScreens
import com.evgenii.goncharov.ancient.egypt.navigation.MainActivityNavigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var router: Router
    private val navigator = MainActivityNavigator(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if(false) {
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