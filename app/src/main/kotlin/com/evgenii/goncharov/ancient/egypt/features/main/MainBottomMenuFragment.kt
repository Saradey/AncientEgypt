package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBottomMenuBinding

class MainBottomMenuFragment : Fragment(R.layout.fragment_main_bottom_menu) {

    private val vb: FragmentMainBottomMenuBinding by viewBinding(FragmentMainBottomMenuBinding::bind)
    private var selectedTab: Int = -1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vb.bnvMenu.setOnItemSelectedListener { menu ->
            if (selectedTab != menu.itemId) {
                selectedTab = menu.itemId
                navigationToTab(selectedTab)
            }
            true
        }
    }

    private fun navigationToTab(itemId: Int) {

    }
}