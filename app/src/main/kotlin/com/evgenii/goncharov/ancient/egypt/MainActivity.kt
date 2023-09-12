package com.evgenii.goncharov.ancient.egypt

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.navigation.MainActivityNavigator
import com.evgenii.goncharov.ancient.egypt.navigation.OnBackPressedActivityManager
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var onBackPressed: OnBackPressedActivityManager
    private val navigator = MainActivityNavigator(this)
    private var keepSplashScreen = true
    private val keepOnScreenCondition = SplashScreen.KeepOnScreenCondition {
        keepSplashScreen
    }
    private val handlerSplashScreen = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        configSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this, onBackPressed)
        savedInstanceState ?: viewModel.startFirstScreen()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun configSplashScreen() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition(keepOnScreenCondition)
            handlerSplashScreen.postDelayed({ keepSplashScreen = false }, DELAY_SPLASH_SCREEN_MILLISECONDS)
        }
    }

    private companion object {
        const val DELAY_SPLASH_SCREEN_MILLISECONDS = 1200L
    }
}