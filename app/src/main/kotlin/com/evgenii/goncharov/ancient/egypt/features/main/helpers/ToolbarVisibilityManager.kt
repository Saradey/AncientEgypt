package com.evgenii.goncharov.ancient.egypt.features.main.helpers

import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens.SCREEN_KEY_ALL_ARTICLES
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SetVisibilityToBottomMenuToolbarListener

class ToolbarVisibilityManager(
    private val setVisibilityToolbarListener: SetVisibilityToBottomMenuToolbarListener
) {

    fun visibilityToolbarChange(screenKey: String) {
        when(screenKey) {
            SCREEN_KEY_ALL_ARTICLES -> setVisibilityToolbarListener.setVisibilityToolbar(true)
            else -> setVisibilityToolbarListener.setVisibilityToolbar(false)
        }
    }
}