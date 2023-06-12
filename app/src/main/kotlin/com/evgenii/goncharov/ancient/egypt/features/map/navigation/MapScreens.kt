package com.evgenii.goncharov.ancient.egypt.features.map.navigation

import com.evgenii.goncharov.ancient.egypt.base.BaseFragmentScreen
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_MAIN
import com.evgenii.goncharov.ancient.egypt.features.map.fragments.AncientEgyptMapFragment
import com.evgenii.goncharov.ancient.egypt.features.map.fragments.SelectedArticleMapBottomSheetFragment
import com.evgenii.goncharov.ancient.egypt.navigation.MainActivityNavigator.Companion.SCREEN_KEY_SELECTED_BOTTOM_SHEET_ARTICLE
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MapScreens {

    fun startAncientEgyptMapAllObjects() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_MAP,
        baskStackName = BACKSTACK_NAME_MAIN
    ) {
        AncientEgyptMapFragment.newInstance(openArticleToBottomSheet = false)
    }

    fun startAncientEgyptMapAndArticle() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_MAP,
        baskStackName = BACKSTACK_NAME_MAIN
    ) {
        AncientEgyptMapFragment.newInstance(openArticleToBottomSheet = true)
    }

    fun startSelectedBottomSheetArticle() = FragmentScreen(
        key = SCREEN_KEY_SELECTED_BOTTOM_SHEET_ARTICLE
    ) { _ ->
        SelectedArticleMapBottomSheetFragment.newInstance()
    }

    private const val SCREEN_KEY_MAP = "map_screen"
}