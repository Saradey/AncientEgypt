package com.evgenii.goncharov.ancient.egypt.features.map.navigation

import com.evgenii.goncharov.ancient.egypt.base.BaseFragmentScreen
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_EVERYWHERE
import com.evgenii.goncharov.ancient.egypt.features.map.fragments.AncientEgyptMapFragment
import com.evgenii.goncharov.ancient.egypt.features.map.fragments.SelectedArticleMapBottomSheetFragment
import com.evgenii.goncharov.ancient.egypt.navigation.MainActivityNavigator.Companion.SCREEN_KEY_SELECTED_BOTTOM_SHEET_ARTICLE
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MapScreens {

    /**
     * Navigation bottom menu container
     */
    fun startAncientEgyptMapAllObjects() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_MAP,
        baskStackName = BACKSTACK_NAME_EVERYWHERE
    ) {
        AncientEgyptMapFragment.newInstance(openArticleToBottomSheet = false)
    }

    fun startAncientEgyptMapAndArticle() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_MAP,
        baskStackName = BACKSTACK_NAME_EVERYWHERE
    ) {
        AncientEgyptMapFragment.newInstance(openArticleToBottomSheet = true)
    }

    /**
     * Navigation activity container
     */
    fun startSelectedBottomSheetArticle() = FragmentScreen(
        key = SCREEN_KEY_SELECTED_BOTTOM_SHEET_ARTICLE
    ) { _ ->
        SelectedArticleMapBottomSheetFragment.newInstance()
    }

    fun startAncientEgyptMapAndArticleActivityContainer() = FragmentScreen {
        AncientEgyptMapFragment.newInstance(openArticleToBottomSheet = true)
    }

    private const val SCREEN_KEY_MAP = "map_screen"
}