package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBottomMenuBinding
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator

/** №2.1 */
class MainBottomMenuFragment : Fragment(R.layout.fragment_main_bottom_menu) {


    private val binding: FragmentMainBottomMenuBinding by viewBinding(FragmentMainBottomMenuBinding::bind)
    private val navigator: MainBottomNavigator = MainBottomNavigator(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {
        fun newInstance() = MainBottomMenuFragment()
    }
}