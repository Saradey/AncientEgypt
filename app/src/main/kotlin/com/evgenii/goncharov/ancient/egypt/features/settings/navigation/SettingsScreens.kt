package com.evgenii.goncharov.ancient.egypt.features.settings.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgenii.goncharov.ancient.egypt.features.settings.SettingsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object SettingsScreens {

    fun startSettings() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_SETTINGS
        override fun createFragment(factory: FragmentFactory): Fragment {
            return SettingsFragment.newInstance()
        }
    }

    private const val BACKSTACK_NAME_SETTINGS = "settings"
}