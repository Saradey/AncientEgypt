package com.evgenii.goncharov.ancient.egypt.features.main.utils

import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.AllArticlesScreen
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SetVisibilityToBottomMenuToolbarListener
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.StartMainScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ToolbarVisibilityManager(
    private val setVisibilityToolbarListener: SetVisibilityToBottomMenuToolbarListener
) {

    fun visibilityToolbarChange(fragmentScreen: FragmentScreen) {
        when (fragmentScreen) {
            is AllArticlesScreen, is StartMainScreen -> {
                setVisibilityToolbarListener.setVisibilityToolbar(true)
            }

            else -> {
                setVisibilityToolbarListener.setVisibilityToolbar(false)
            }
        }
    }
}