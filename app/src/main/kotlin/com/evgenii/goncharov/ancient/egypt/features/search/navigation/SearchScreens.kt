package com.evgenii.goncharov.ancient.egypt.features.search.navigation

import com.evgenii.goncharov.ancient.egypt.base.BaseFragmentScreen
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_EVERYWHERE
import com.evgenii.goncharov.ancient.egypt.features.search.SearchFragment

object SearchScreens {

    fun startSearch() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_SEARCH,
        baskStackName = BACKSTACK_NAME_EVERYWHERE
    ) {
        SearchFragment.newInstance()
    }

    private const val SCREEN_KEY_SEARCH = "search_screen"
}