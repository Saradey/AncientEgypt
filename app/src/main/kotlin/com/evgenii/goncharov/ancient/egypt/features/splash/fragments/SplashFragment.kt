package com.evgenii.goncharov.ancient.egypt.features.splash.fragments

import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.LayoutSplashScreenBinding
import com.evgenii.goncharov.ancient.egypt.features.splash.view.models.SplashViewModel
import com.evgenii.goncharov.ancient.egypt.utils.StatusBarUtils
import dagger.hilt.android.AndroidEntryPoint

/**
 * №1.1
 * Doc: https://docs.google.com/document/d/1F1Zrl4_34N6EHaRokRRkvdzFWI5mwvYdAG7agRLmyyk/edit
 * */
@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.layout_splash_screen) {

    private val viewModel: SplashViewModel by viewModels()
    private val binding: LayoutSplashScreenBinding by viewBinding(LayoutSplashScreenBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.hideSystemUi(requireActivity().window)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun LayoutSplashScreenBinding.initUi() {
        val animated = (binding.imvSplash.drawable as AnimatedVectorDrawable)
        animated.start()
        animated.registerAnimationCallback(
            object : Animatable2.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    viewModel.navigationToNext()
                }
            }
        )
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}