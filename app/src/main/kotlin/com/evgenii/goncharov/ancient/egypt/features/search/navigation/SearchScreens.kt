package com.evgenii.goncharov.ancient.egypt.features.search.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_EVERYWHERE
import com.evgenii.goncharov.ancient.egypt.features.search.SearchFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object SearchScreens {

    fun startSearch() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_EVERYWHERE
        override fun createFragment(factory: FragmentFactory): Fragment {
            return SearchFragment.newInstance()
        }
    }
}