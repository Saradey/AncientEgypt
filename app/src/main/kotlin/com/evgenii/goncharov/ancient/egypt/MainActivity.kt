package com.evgenii.goncharov.ancient.egypt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.navigation.MainActivityNavigator
import com.evgenii.goncharov.ancient.egypt.navigation.OnBackPressedActivityManager
import com.evgenii.goncharov.ancient.egypt.utils.SplashHelper.configSplashScreen
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
}