package com.evgenii.goncharov.ancient.egypt.features.map.navigation

import com.evgenii.goncharov.ancient.egypt.features.map.AncientEgyptMapFragment
import com.evgenii.goncharov.ancient.egypt.features.map.SelectedArticleMapBottomSheetFragment
import com.evgenii.goncharov.ancient.egypt.navigation.MainActivityNavigator.Companion.SCREEN_KEY_SELECTED_BOTTOM_SHEET_ARTICLE
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MapScreens {

    fun startAncientEgyptMapAllObjects() = FragmentScreen {
        AncientEgyptMapFragment.newInstance(openArticleToBottomSheet = false)
    }

    fun startAncientEgyptMapAndArticle() = FragmentScreen {
        AncientEgyptMapFragment.newInstance(openArticleToBottomSheet = true)
    }

    fun startSelectedBottomSheetArticle() = FragmentScreen(
        key = SCREEN_KEY_SELECTED_BOTTOM_SHEET_ARTICLE
    ) {
        SelectedArticleMapBottomSheetFragment.newInstance()
    }
}