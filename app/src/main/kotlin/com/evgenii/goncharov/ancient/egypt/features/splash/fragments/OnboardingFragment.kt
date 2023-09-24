package com.evgenii.goncharov.ancient.egypt.features.splash.fragments

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.AnimationListenerDefault
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
        StatusBarUtils.hideSystemUi(requireActivity().window)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
        initModels()
        startAnimationScreen()
    }

    private fun FragmentOnboardingBinding.initUi() {
        initViewPager()
        initButtons()
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
                        dtiIndicator.nextPage = nextDotsIndicator + PLUS_INDEX
                    }
                    if (position >= LAST_PAGE_INDEX) {
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
            viewModel.goToTheMainBottomMenu()
        }
        txvNext.setOnClickListener {
            if (vp2Content.currentItem >= LAST_PAGE_INDEX) {
                viewModel.goToTheMainBottomMenu()
            } else {
                vp2Content.currentItem++
            }
        }
    }

    private fun startAnimationScreen() {
        binding.startAnimationBottom()
        binding.startAnimationOther()
    }

    private fun FragmentOnboardingBinding.startAnimationBottom() {
        val animationShow = AnimationUtils.loadAnimation(
            context,
            R.anim.bottom_onboarding_element_show
        )
        txvNext.startAnimation(animationShow)
        dtiIndicator.startAnimation(animationShow)
        animationShow.setAnimationListener(object : AnimationListenerDefault() {
            override fun onAnimationEnd(animation: Animation?) {
                txvNext.isEnabled = true
            }
        })
    }

    private fun FragmentOnboardingBinding.startAnimationOther() {
        val animationCenter = AnimationUtils.loadAnimation(
            context,
            R.anim.centre_onboarding_element_show
        )
        vp2Content.startAnimation(animationCenter)
        val animationTop = AnimationUtils.loadAnimation(
            context,
            R.anim.bottom_onboarding_element_show
        )
        txvSkip.startAnimation(animationTop)
        animationTop.setAnimationListener(object : AnimationListenerDefault() {
            override fun onAnimationEnd(animation: Animation?) {
                txvSkip.isEnabled = true
            }
        })
    }

    companion object {
        fun newInstance() = OnboardingFragment()

        private const val LAST_PAGE_INDEX = 2
        private const val PLUS_INDEX = 1
    }
}