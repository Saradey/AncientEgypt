package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.BaseNavigator
import com.evgenii.goncharov.ancient.egypt.features.main.MainBottomMenuFragment
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import java.util.Stack

class MainBottomNavigator(
    private val mainBottomMenuFragment: MainBottomMenuFragment
) : BaseNavigator(
    fm = mainBottomMenuFragment.childFragmentManager,
    ff = mainBottomMenuFragment.childFragmentManager.fragmentFactory,
    containerId = R.id.fcv_nested_container_bottom_menu
) {

    private val localBackStack: Stack<String> = Stack()
    private var selectedBackstackMenu = ""

    override fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward(command)
            is Back -> back()
        }
    }

    private fun forward(command: Forward) {
        val fragmentScreen = command.screen
        val backStackName = fragmentScreen.screenKey

    }

    private fun back() {}

    companion object {
        const val BACKSTACK_NAME_MAIN = "main"
        const val BACKSTACK_NAME_FAVORITE = "favorite"
        const val BACKSTACK_NAME_ALL = "all"
        const val BACKSTACK_NAME_SETTINGS = "settings"
    }
}