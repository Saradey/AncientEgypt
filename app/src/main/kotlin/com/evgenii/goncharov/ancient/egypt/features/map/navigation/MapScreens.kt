package com.evgenii.goncharov.ancient.egypt.features.map.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgenii.goncharov.ancient.egypt.features.map.AncientEgyptMapFragment
import com.evgenii.goncharov.ancient.egypt.features.map.SelectedArticleMapBottomSheetFragment
import com.evgenii.goncharov.ancient.egypt.navigation.MainActivityNavigator.Companion.SCREEN_KEY_SELECTED_BOTTOM_SHEET_ARTICLE
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MapScreens {

    fun startAncientEgyptMapAllObjects() = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return AncientEgyptMapFragment.newInstance(openArticleToBottomSheet = false)
        }
    }

    fun startAncientEgyptMapAndArticle() = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return AncientEgyptMapFragment.newInstance(openArticleToBottomSheet = true)
        }
    }

    fun startSelectedBottomSheetArticle() = FragmentScreen(
        key = SCREEN_KEY_SELECTED_BOTTOM_SHEET_ARTICLE
    ) {
        SelectedArticleMapBottomSheetFragment.newInstance()
    }
}