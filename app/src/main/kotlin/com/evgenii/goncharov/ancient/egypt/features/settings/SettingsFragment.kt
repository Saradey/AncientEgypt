package com.evgenii.goncharov.ancient.egypt.features.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSettingsBinding

/**
 * №5
 * Doc: https://docs.google.com/document/d/1XxF4-QgJwNdQS0qmGbExqcWTNj8nNXbvZ2buaRaHsFg/edit
 * */
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val binding: FragmentSettingsBinding by viewBinding(FragmentSettingsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.title.text = "${binding.title.text} ${toString()}"
    }

    companion object {
        fun newInstance() = SettingsFragment()
    }
}