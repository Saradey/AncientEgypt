package com.evgenii.goncharov.ancient.egypt.features.map.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgenii.goncharov.ancient.egypt.features.map.AncientEgyptMapFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MapScreens {

    fun startAncientEgyptMapAndArticle() = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return AncientEgyptMapFragment.newInstance(openArticleToBottomSheet = true)
        }
    }
}