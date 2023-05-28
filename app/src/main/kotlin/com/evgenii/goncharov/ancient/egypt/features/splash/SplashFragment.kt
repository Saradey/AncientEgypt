package com.evgenii.goncharov.ancient.egypt.features.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val vb: FragmentSplashBinding by viewBinding(FragmentSplashBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb.btnNext.setOnClickListener {

        }
    }
}