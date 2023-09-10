package com.evgenii.goncharov.ancient.egypt.features.splash.ui

import com.evgenii.goncharov.ancient.egypt.databinding.ItemOnboardingBinding
import com.evgenii.goncharov.ancient.egypt.features.splash.models.OnboardingModel
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun onboardingDelegate() =
    adapterDelegateViewBinding<OnboardingModel, OnboardingModel, ItemOnboardingBinding>(
        { layoutInflater, root -> ItemOnboardingBinding.inflate(layoutInflater, root, false) }
    ) {
        binding.imvOnboarding.setImageResource(item.idImage)
        binding.txvOnboardingDescription.setText(item.textDescription)
    }