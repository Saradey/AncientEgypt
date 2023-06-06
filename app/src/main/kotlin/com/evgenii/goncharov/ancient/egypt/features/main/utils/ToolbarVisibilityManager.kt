package com.evgenii.goncharov.ancient.egypt.features.main.utils

import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SetVisibilityToBottomMenuToolbarListener
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_ALL
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_MAIN

class ToolbarVisibilityManager(
    private val setVisibilityToolbarListener: SetVisibilityToBottomMenuToolbarListener
) {

    fun visibilityToolbarChange(backStackName: String) {
        when(backStackName) {
            BACKSTACK_NAME_MAIN,
            BACKSTACK_NAME_ALL -> setVisibilityToolbarListener.setVisibilityToolbar(true)
            else -> setVisibilityToolbarListener.setVisibilityToolbar(false)
        }
    }
}