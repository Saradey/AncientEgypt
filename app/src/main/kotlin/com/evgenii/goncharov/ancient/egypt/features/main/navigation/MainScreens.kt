package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import com.evgenii.goncharov.ancient.egypt.features.main.MainBottomMenuFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MainScreens {

    fun startMainBottomMenu() = FragmentScreen { _ ->
        MainBottomMenuFragment.newInstance()
    }
}