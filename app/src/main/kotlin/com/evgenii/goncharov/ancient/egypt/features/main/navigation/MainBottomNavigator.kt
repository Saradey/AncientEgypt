package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import androidx.fragment.app.commit
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.BaseNavigator
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SelectTabBottomMenuListener
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SetVisibilityToBottomMenuToolbarListener
import com.evgenii.goncharov.ancient.egypt.features.main.utils.ToolbarVisibilityManager
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
    private val mainActivityRouter: Router,
    setVisibilityToolbarListener: SetVisibilityToBottomMenuToolbarListener
) : BaseNavigator(
    fm = fragmentManager, ff = fragmentFactory, containerId = R.id.fcv_nested_container_bottom_menu
) {

    private val localBackStack: Stack<BackStackInfo> = Stack()
    private var selectedBackStack: BackStackInfo = BackStackInfo("", 0)
    private val toolbarVisibilityManager = ToolbarVisibilityManager(setVisibilityToolbarListener)

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
            backStackName == BACKSTACK_NAME_EVERYWHERE -> commitFragmentToCurrentStack(
                fragmentScreen = fragmentScreen
            )

            localBackStack.any { info -> info.backStackName == backStackName } -> restoreBackStack(
                backStackName
            )

            selectedBackStack.backStackName != backStackName -> addedNewBackStack(
                fragmentScreen,
                backStackName
            )
        }
    }

    private fun addedNewBackStack(fragmentScreen: FragmentScreen, backStackName: String) {
        if (selectedBackStack.backStackName.isNotEmpty()) {
            fm.saveBackStack(selectedBackStack.backStackName)
        }
        val fragment = fragmentScreen.createFragment(ff)
        fm.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment, fragmentScreen.screenKey)
            addToBackStack(backStackName)
        }
        selectedBackStack = BackStackInfo(
            backStackName, FIRST_INDEX_FRAGMENT_TO_BACKSTACK
        )
        localBackStack.push(selectedBackStack)
        toolbarVisibilityManager.visibilityToolbarChange(backStackName)
    }

    private fun restoreBackStack(backStackName: String) {
        fm.saveBackStack(selectedBackStack.backStackName)
        val info = localBackStack.find { info -> info.backStackName == backStackName }
        info?.let { _info -> selectedBackStack = _info }
        fm.restoreBackStack(info?.backStackName ?: throw IllegalArgumentException())
        localBackStack.remove(info)
        localBackStack.push(info)
        toolbarVisibilityManager.visibilityToolbarChange(backStackName)
    }

    private fun commitFragmentToCurrentStack(
        fragmentScreen: FragmentScreen,
    ) {
        val fragment = fragmentScreen.createFragment(ff)
        fm.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment, fragmentScreen.screenKey)
            addToBackStack(selectedBackStack.backStackName)
            selectedBackStack.countBackStack++
        }
    }

    private fun back() {
        when {
            selectedBackStack.countBackStack > FIRST_INDEX_FRAGMENT_TO_BACKSTACK -> popFragmentToCurrentBackStack()

            localBackStack.size <= FIRST_INDEX_FRAGMENT_TO_BACKSTACK -> mainActivityRouter.exit()

            else -> popCurrentBackStack()
        }
    }

    private fun popFragmentToCurrentBackStack() {
        fm.popBackStack()
        selectedBackStack.countBackStack--
    }

    private fun popCurrentBackStack() {
        val popBackStack = localBackStack.pop()
        fm.popBackStack(popBackStack.backStackName, POP_BACK_STACK_INCLUSIVE)
        selectedBackStack = localBackStack.peek()
        listener.selectTabBottomMenu(selectedBackStack.backStackName)
        fm.restoreBackStack(selectedBackStack.backStackName)
        toolbarVisibilityManager.visibilityToolbarChange(popBackStack.backStackName)
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

data class BackStackInfo(
    val backStackName: String, var countBackStack: Int
)