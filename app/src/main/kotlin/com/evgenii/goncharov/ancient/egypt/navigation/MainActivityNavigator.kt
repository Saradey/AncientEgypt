package com.evgenii.goncharov.ancient.egypt.navigation

import com.evgenii.goncharov.ancient.egypt.MainActivity
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.BaseNavigator
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward

class MainActivityNavigator(
    mainActivity: MainActivity
) : BaseNavigator(
    mainActivity.supportFragmentManager,
    mainActivity.supportFragmentManager.fragmentFactory,
    R.id.fcv_root_container
) {

    override fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward()
        }
    }

    private fun forward() {

    }
}