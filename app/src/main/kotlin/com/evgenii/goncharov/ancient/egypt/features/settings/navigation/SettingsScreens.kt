package com.evgenii.goncharov.ancient.egypt.features.settings.navigation

import com.evgenii.goncharov.ancient.egypt.base.BaseFragmentScreen
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_SETTINGS
import com.evgenii.goncharov.ancient.egypt.features.settings.SettingsFragment

object SettingsScreens {

    /**
     * Navigation bottom menu container
     */
    fun startSettings() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_SETTINGS,
        baskStackName = BACKSTACK_NAME_SETTINGS
    ) {
        SettingsFragment.newInstance()
    }

    private const val SCREEN_KEY_SETTINGS = "settings_screen"
}