package com.evgenii.goncharov.ancient.egypt.features.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentOnboardingBinding

/** №1.2 */
class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private val vb: FragmentOnboardingBinding by viewBinding(FragmentOnboardingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vb.btnNext.setOnClickListener {
            val navController = findNavController()
            navController.navigate(OnboardingFragmentDirections.actionOnbaordingToMain())
        }
    }
}