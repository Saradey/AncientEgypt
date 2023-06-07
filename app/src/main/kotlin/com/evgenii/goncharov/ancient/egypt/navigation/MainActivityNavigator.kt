package com.evgenii.goncharov.ancient.egypt.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.evgenii.goncharov.ancient.egypt.MainActivity
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.BaseNavigator
import com.evgenii.goncharov.ancient.egypt.features.map.SelectedArticleMapBottomSheetFragment
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

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
        val screenKey = fragmentScreen.screenKey
        if (screenKey == SCREEN_KEY_SELECTED_BOTTOM_SHEET_ARTICLE) {
            showBottomSheet(fragment as SelectedArticleMapBottomSheetFragment, screenKey)
        } else {
            commitFragmentTransaction(fragment, fragmentScreen, fragmentScreen.screenKey)
        }
    }

    private fun showBottomSheet(bottomSheet: BottomSheetDialogFragment, tag: String?) {
        bottomSheet.show(mainActivity.supportFragmentManager, tag)
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

    private fun commitFragmentTransaction(
        fragment: Fragment,
        fragmentScreen: FragmentScreen,
        backStackName: String
    ) {
        fm.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment, fragmentScreen.screenKey)
            addToBackStack(backStackName)
        }
    }

    private fun back() {
        if (fm.backStackEntryCount > FIRST_INDEX_FRAGMENT_TO_BACKSTACK) {
            fm.popBackStack()
        } else {
            mainActivity.finish()
        }
    }

    companion object {
        const val SCREEN_KEY_SELECTED_BOTTOM_SHEET_ARTICLE = "selectedBottomSheetArticle"
        private const val FIRST_INDEX_FRAGMENT_TO_BACKSTACK = 1
    }
}