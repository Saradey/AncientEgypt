package com.evgenii.goncharov.ancient.egypt.features.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSplashBinding
import com.evgenii.goncharov.ancient.egypt.features.splash.navigation.SplashScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/** №1.1 */
@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject lateinit var activityRouter: Router

    private val binding: FragmentSplashBinding by viewBinding(FragmentSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnNext.setOnClickListener {
            if (false) {

            } else {
                activityRouter.navigateTo(SplashScreens.startOnboarding())
            }
        }
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}