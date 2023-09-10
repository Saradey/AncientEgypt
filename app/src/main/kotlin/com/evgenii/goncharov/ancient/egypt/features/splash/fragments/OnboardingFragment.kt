package com.evgenii.goncharov.ancient.egypt.features.splash.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentOnboardingBinding
import com.evgenii.goncharov.ancient.egypt.features.splash.view.models.OnboardingViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * №1.2
 * Doc: https://docs.google.com/document/d/1EdY8R0Q8JSbbIal91mItRfiE5uuL7Uj6joi3SajIasU/edit
 * */
@AndroidEntryPoint
class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private val viewModel: OnboardingViewModel by viewModels()
    private val binding: FragmentOnboardingBinding by viewBinding(FragmentOnboardingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentOnboardingBinding.initUi() {
//        title.text = "${binding.title.text} ${toString()}"
//        btnNext.setOnClickListener {
//            viewModel.goToTheMainBottomMenu()
//        }
    }

    companion object {
        fun newInstance() = OnboardingFragment()
    }
}