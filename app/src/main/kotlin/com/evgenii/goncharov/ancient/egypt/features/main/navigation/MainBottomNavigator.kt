package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import android.os.Parcelable
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import androidx.fragment.app.commit
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.BaseFragmentScreen
import com.evgenii.goncharov.ancient.egypt.base.BaseNavigator
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.main.fragments.MainBottomMenuFragment
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SelectTabBottomMenuListener
import com.evgenii.goncharov.ancient.egypt.features.main.utils.ToolbarVisibilityManager
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.parcelize.Parcelize
import java.util.Stack
import javax.inject.Named

class MainBottomNavigator @AssistedInject constructor(
    @Assisted("mainBottomMenuFragment") mainBottomMenuFragment: MainBottomMenuFragment,
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
) : BaseNavigator(
    fm = mainBottomMenuFragment.childFragmentManager,
    ff = mainBottomMenuFragment.childFragmentManager.fragmentFactory,
    containerId = R.id.fcv_nested_container_bottom_menu
) {

    var localBackStack: Stack<BackStackInfo> = Stack()
    var selectedBackStack: BackStackInfo = BackStackInfo("", Stack())
    private val toolbarVisibilityManager = ToolbarVisibilityManager(mainBottomMenuFragment)
    private val listener: SelectTabBottomMenuListener = mainBottomMenuFragment

    override fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward(command)
            is Back -> back()
        }
    }

    private fun forward(command: Forward) {
        val fragmentScreen = command.screen as BaseFragmentScreen
        val backStackName = fragmentScreen.baskStackName
        when {
            backStackName == BACKSTACK_NAME_EVERYWHERE -> commitFragmentToCurrentStack(
                fragmentScreen = fragmentScreen
            )

            localBackStack.any { info -> info.backStackName == backStackName } -> restoreBackStack(
                backStackName
            )

            selectedBackStack.backStackName != backStackName -> addedNewBackStack(
                fragmentScreen, backStackName
            )
        }
    }

    private fun addedNewBackStack(fragmentScreen: BaseFragmentScreen, backStackName: String) {
        if (selectedBackStack.backStackName.isNotEmpty()) {
            fm.saveBackStack(selectedBackStack.backStackName)
        }
        val fragment = fragmentScreen.createFragment(ff)
        fm.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment, fragmentScreen.screenKey)
            addToBackStack(backStackName)
        }
        val backStackScreens = Stack<String>()
        backStackScreens.add(fragmentScreen.screenKey)
        selectedBackStack = BackStackInfo(backStackName, backStackScreens)
        localBackStack.push(selectedBackStack)
        toolbarVisibilityManager.visibilityToolbarChange(fragmentScreen.screenKey)
    }

    private fun restoreBackStack(backStackName: String) {
        fm.saveBackStack(selectedBackStack.backStackName)
        val info = localBackStack.find { info -> info.backStackName == backStackName }
        info?.let { _info -> selectedBackStack = _info }
        fm.restoreBackStack(info?.backStackName ?: throw IllegalArgumentException())
        localBackStack.remove(info)
        localBackStack.push(info)
        toolbarVisibilityManager.visibilityToolbarChange(selectedBackStack.screensKey.peek())
    }

    private fun commitFragmentToCurrentStack(
        fragmentScreen: BaseFragmentScreen,
    ) {
        val fragment = fragmentScreen.createFragment(ff)
        fm.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment, fragmentScreen.screenKey)
            addToBackStack(selectedBackStack.backStackName)
        }
        selectedBackStack.screensKey.push(fragmentScreen.screenKey)
        toolbarVisibilityManager.visibilityToolbarChange(selectedBackStack.screensKey.peek())
    }

    private fun back() {
        when {
            selectedBackStack.screensKey.size > FIRST_INDEX_FRAGMENT_TO_BACKSTACK -> popFragmentToCurrentBackStack()

            localBackStack.size <= FIRST_INDEX_FRAGMENT_TO_BACKSTACK -> activityRouter.exit()

            else -> popCurrentBackStack()
        }
    }

    private fun popFragmentToCurrentBackStack() {
        fm.popBackStack()
        selectedBackStack.screensKey.pop()
        toolbarVisibilityManager.visibilityToolbarChange(selectedBackStack.screensKey.peek())
    }

    private fun popCurrentBackStack() {
        val popBackStack = localBackStack.pop()
        fm.popBackStack(popBackStack.backStackName, POP_BACK_STACK_INCLUSIVE)
        selectedBackStack = localBackStack.peek()
        listener.selectTabBottomMenu(selectedBackStack.backStackName)
        fm.restoreBackStack(selectedBackStack.backStackName)
        val pushedScreenKey = selectedBackStack.screensKey.peek()
        toolbarVisibilityManager.visibilityToolbarChange(pushedScreenKey)
    }

    fun checkToolbarStatus() {
        if(selectedBackStack.screensKey.isNotEmpty()) {
            val currentScreen = selectedBackStack.screensKey.peek()
            toolbarVisibilityManager.visibilityToolbarChange(currentScreen)
        }
    }

    @AssistedFactory
    interface Factory {

        fun create(
            @Assisted("mainBottomMenuFragment") mainBottomMenuFragment: MainBottomMenuFragment
        ): MainBottomNavigator
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

@Parcelize
data class BackStackInfo(
    val backStackName: String, val screensKey: Stack<String>
) : Parcelable