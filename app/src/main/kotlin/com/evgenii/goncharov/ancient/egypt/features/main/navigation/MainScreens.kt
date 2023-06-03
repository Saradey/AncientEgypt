package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgenii.goncharov.ancient.egypt.features.main.MainBottomMenuFragment
import com.evgenii.goncharov.ancient.egypt.features.main.MainFragment
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_MAIN
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MainScreens {

    fun startMainBottomMenu() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_BOTTOM_MENU
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MainBottomMenuFragment.newInstance()
        }
    }

    fun startMain() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_MAIN
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MainFragment.newInstance()
        }
    }

    private const val BACKSTACK_NAME_BOTTOM_MENU = "bottomMenu"
}