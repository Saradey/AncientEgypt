package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import com.evgenii.goncharov.ancient.egypt.base.BaseFragmentScreen
import com.evgenii.goncharov.ancient.egypt.features.main.fragments.MainBottomMenuFragment
import com.evgenii.goncharov.ancient.egypt.features.main.fragments.MainFragment
import com.evgenii.goncharov.ancient.egypt.features.main.fragments.StoriesFragment
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_MAIN
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MainScreens {

    /**
     * Navigation bottom menu container
     */
    fun startMain() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_MAIN_MENU,
        baskStackName = BACKSTACK_NAME_MAIN
    ) {
        MainFragment.newInstance()
    }

    fun startStories(model: SelectedStoriesModel) = FragmentScreen{ _ ->
        StoriesFragment.newInstance(model)
    }

    /**
     * Navigation activity container
     */
    fun startMainBottomMenu() = FragmentScreen(
        key = SCREEN_KEY_BOTTOM_MENU
    ) { _ ->
        MainBottomMenuFragment.newInstance()
    }

    private const val SCREEN_KEY_BOTTOM_MENU = "bottomMenu"
    private const val SCREEN_KEY_MAIN_MENU = "main_menu_screen"
}