package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.BaseNavigator
import com.evgenii.goncharov.ancient.egypt.features.main.MainBottomMenuFragment
import com.github.terrakok.cicerone.Command

class MainBottomNavigator(
    private val mainBottomMenuFragment: MainBottomMenuFragment
) : BaseNavigator(
    fm = mainBottomMenuFragment.childFragmentManager,
    ff = mainBottomMenuFragment.childFragmentManager.fragmentFactory,
    containerId = R.id.fcv_nested_container_bottom_menu
) {

    override fun applyCommand(command: Command) {

    }
}