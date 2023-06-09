package com.evgenii.goncharov.ancient.egypt.features.splash.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSplashBinding
import com.evgenii.goncharov.ancient.egypt.features.splash.view.models.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * №1.1
 * Doc: https://docs.google.com/document/d/1F1Zrl4_34N6EHaRokRRkvdzFWI5mwvYdAG7agRLmyyk/edit
 * */
@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel: SplashViewModel by viewModels()
    private val binding: FragmentSplashBinding by viewBinding(FragmentSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentSplashBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
        btnNext.setOnClickListener {
            viewModel.navigationToNext()
        }
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}