package com.evgenii.goncharov.ancient.egypt.features.splash.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentOnboardingBinding
import com.evgenii.goncharov.ancient.egypt.features.splash.ui.OnboardingAdapter
import com.evgenii.goncharov.ancient.egypt.features.splash.view.models.OnboardingViewModel
import com.evgenii.goncharov.ancient.egypt.utils.StatusBarUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * №1.2
 * Doc: https://docs.google.com/document/d/1EdY8R0Q8JSbbIal91mItRfiE5uuL7Uj6joi3SajIasU/edit
 * */
@AndroidEntryPoint
class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private val viewModel: OnboardingViewModel by viewModels()
    private val binding: FragmentOnboardingBinding by viewBinding(FragmentOnboardingBinding::bind)
    private var nextDotsIndicator = 0
    private val adapter = OnboardingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.hideStatusBar(requireActivity().window)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
        initModels()
    }

    private fun FragmentOnboardingBinding.initUi() {
        initViewPager()
        initButtons()
        startAnimationScreen()
    }

    private fun initModels() {
        lifecycleScope.launch {
            viewModel.onboardingInfo.collectLatest { models -> adapter.items = models }
        }
    }

    private fun FragmentOnboardingBinding.initViewPager() {
        vp2Content.adapter = adapter
        vp2Content.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    if (nextDotsIndicator != position) {
                        nextDotsIndicator = position
                        dtiIndicator.nextPage = nextDotsIndicator + 1
                    }
                    if (position >= 2) {
                        txvNext.setText(R.string.get_started)
                    } else {
                        txvNext.setText(R.string.next)
                    }
                }
            }
        )
    }

    private fun FragmentOnboardingBinding.initButtons() {
        txvSkip.setOnClickListener {
            //TODO navigation
        }
        txvNext.setOnClickListener {
            if (vp2Content.currentItem >= 2) {
                //TODO navigation
            } else {
                vp2Content.currentItem++
            }
        }
    }

    private fun FragmentOnboardingBinding.startAnimationScreen() {

    }

    companion object {
        fun newInstance() = OnboardingFragment()
    }
}