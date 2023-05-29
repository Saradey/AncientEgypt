package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBottomMenuBinding

/** №2.1 */
class MainBottomMenuFragment : Fragment(R.layout.fragment_main_bottom_menu) {

    private val vb: FragmentMainBottomMenuBinding by viewBinding(FragmentMainBottomMenuBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}