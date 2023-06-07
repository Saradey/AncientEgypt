package com.evgenii.goncharov.ancient.egypt.features.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentOnboardingBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/**
 * №1.2
 * https://docs.google.com/document/d/1EdY8R0Q8JSbbIal91mItRfiE5uuL7Uj6joi3SajIasU/edit
 * */
@AndroidEntryPoint
class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var mainActivityRouter: Router
    private val binding: FragmentOnboardingBinding by viewBinding(FragmentOnboardingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnNext.setOnClickListener {
            mainActivityRouter.replaceScreen(MainScreens.startMainBottomMenu())
        }
    }

    companion object {
        fun newInstance() = OnboardingFragment()
    }
}