package com.evgenii.goncharov.ancient.egypt.features.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSplashBinding

/** №1.1 */
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val vb: FragmentSplashBinding by viewBinding(FragmentSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vb.btnNext.setOnClickListener {
            val navController = findNavController()
            if (false) {
                navController.navigate(SplashFragmentDirections.actionSplashToMain())
            } else {
                navController.navigate(SplashFragmentDirections.actionSplashToOnboarding())
            }
        }
    }
}