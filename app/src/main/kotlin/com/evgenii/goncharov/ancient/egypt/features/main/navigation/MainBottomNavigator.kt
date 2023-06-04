package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.BaseNavigator
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SelectTabBottomMenuListener
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import java.util.Stack

class MainBottomNavigator(
    fragmentManager: FragmentManager,
    fragmentFactory: FragmentFactory,
    private val listener: SelectTabBottomMenuListener,
    private val mainActivityRouter: Router
) : BaseNavigator(
    fm = fragmentManager,
    ff = fragmentFactory,
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
        val fragmentScreen = command.screen as FragmentScreen
        val backStackName = fragmentScreen.screenKey
        when {
            backStackName == BACKSTACK_NAME_EVERYWHERE -> {
                commit(
                    fragmentScreen = fragmentScreen,
                    backStackName = selectedBackstackMenu
                )
            }

            selectedBackstackMenu != backStackName -> {
                commit(
                    fragmentScreen = fragmentScreen,
                    backStackName = backStackName
                )
                selectedBackstackMenu = backStackName
                if (localBackStack.contains(selectedBackstackMenu)) {
                    localBackStack.remove(selectedBackstackMenu)
                }
                localBackStack.push(selectedBackstackMenu)
            }
        }
    }

    private fun commit(fragmentScreen: FragmentScreen, backStackName: String) {
        if (selectedBackstackMenu.isNotEmpty()) {
            fm.saveBackStack(selectedBackstackMenu)
        }
        if (!localBackStack.contains(backStackName)) {
            val fragment = fragmentScreen.createFragment(ff)
            fm.commit {
                setReorderingAllowed(true)
                replace(containerId, fragment, fragmentScreen.screenKey)
                addToBackStack(backStackName)
            }
        } else {
            fm.restoreBackStack(backStackName)
        }
    }

    private fun back() {
        if (localBackStack.size > FIRST_INDEX_FRAGMENT_TO_BACKSTACK) {
            val popBackStackName = localBackStack.pop()
            fm.popBackStack(popBackStackName, 0)
            selectedBackstackMenu = localBackStack.peek()
            listener.selectTabBottomMenu(selectedBackstackMenu)
            fm.restoreBackStack(selectedBackstackMenu)
        } else {
            mainActivityRouter.exit()
        }
    }

    companion object {
        const val BACKSTACK_NAME_MAIN = "main"
        const val BACKSTACK_NAME_FAVORITE = "favorite"
        const val BACKSTACK_NAME_ALL = "all"
        const val BACKSTACK_NAME_SETTINGS = "settings"
        const val BACKSTACK_NAME_EVERYWHERE = "everywhere"
        private const val FIRST_INDEX_FRAGMENT_TO_BACKSTACK = 1
    }
}