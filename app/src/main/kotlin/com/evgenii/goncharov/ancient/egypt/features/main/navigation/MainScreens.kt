package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import com.evgenii.goncharov.ancient.egypt.base.BaseFragmentScreen
import com.evgenii.goncharov.ancient.egypt.features.main.MainBottomMenuFragment
import com.evgenii.goncharov.ancient.egypt.features.main.MainFragment
import com.evgenii.goncharov.ancient.egypt.features.main.StoriesFragment
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_MAIN
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MainScreens {

    fun startMainBottomMenu() = FragmentScreen(
        key = SCREEN_KEY_BOTTOM_MENU
    ) { _ ->
        MainBottomMenuFragment.newInstance()
    }

    fun startMain() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_MAIN_MENU,
        baskStackName = BACKSTACK_NAME_MAIN
    ) {
        MainFragment.newInstance()
    }

    fun startStories() = FragmentScreen{ _ ->
        StoriesFragment.newInstance()
    }

    private const val SCREEN_KEY_BOTTOM_MENU = "bottomMenu"
    const val SCREEN_KEY_MAIN_MENU = "main_menu_screen"
}