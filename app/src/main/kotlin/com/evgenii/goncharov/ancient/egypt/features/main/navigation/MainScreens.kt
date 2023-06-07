package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgenii.goncharov.ancient.egypt.base.BaseFragmentScreen
import com.evgenii.goncharov.ancient.egypt.features.main.MainBottomMenuFragment
import com.evgenii.goncharov.ancient.egypt.features.main.MainFragment
import com.evgenii.goncharov.ancient.egypt.features.main.StoriesFragment
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_MAIN
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MainScreens {

    fun startMainBottomMenu() = object : FragmentScreen {
        override val screenKey: String = SCREEN_KEY_BOTTOM_MENU
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MainBottomMenuFragment.newInstance()
        }
    }

    fun startMain() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_MAIN_MENU,
        baskStackName = BACKSTACK_NAME_MAIN
    ) {
        MainFragment.newInstance()
    }

    fun startStories() = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return StoriesFragment.newInstance()
        }
    }

    private const val SCREEN_KEY_BOTTOM_MENU = "bottomMenu"
    const val SCREEN_KEY_MAIN_MENU = "main_menu_screen"
}