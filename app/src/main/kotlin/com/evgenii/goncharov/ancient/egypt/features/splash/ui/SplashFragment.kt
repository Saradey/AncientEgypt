package com.evgenii.goncharov.ancient.egypt.features.splash.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSplashBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.splash.navigation.SplashScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/**
 * №1.1
 * Doc: https://docs.google.com/document/d/1F1Zrl4_34N6EHaRokRRkvdzFWI5mwvYdAG7agRLmyyk/edit
 * */
@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var activityRouter: Router

    private val binding: FragmentSplashBinding by viewBinding(FragmentSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnNext.setOnClickListener {
            if (false) {
                activityRouter.replaceScreen(MainScreens.startMainBottomMenu())
            } else {
                activityRouter.replaceScreen(SplashScreens.startOnboarding())
            }
        }
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}