package com.evgenii.goncharov.ancient.egypt.navigation

import com.evgenii.goncharov.ancient.egypt.MainActivity
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.BaseNavigator
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MainActivityNavigator(
    private val mainActivity: MainActivity
) : BaseNavigator(
    mainActivity.supportFragmentManager,
    mainActivity.supportFragmentManager.fragmentFactory,
    R.id.fcv_root_container
) {

    override fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward(command)
            is Replace -> replace(command)
            is Back -> back()
        }
    }

    private fun forward(command: Forward) {
        val fragmentScreen = command.screen as FragmentScreen
        val fragment = fragmentScreen.createFragment(ff)
        commitFragmentTransaction(
            fragment,
            fragmentScreen,
            fragmentScreen.screenKey
        )
    }

    private fun replace(command: Replace) {
        fm.popBackStack()
        val fragmentScreen = command.screen as FragmentScreen
        val fragment = fragmentScreen.createFragment(ff)
        commitFragmentTransaction(
            fragment,
            fragmentScreen,
            fragmentScreen.screenKey
        )
    }

    private fun back() {
        if(fm.backStackEntryCount > 1) {
            fm.popBackStack()
        } else {
            mainActivity.finish()
        }
    }
}