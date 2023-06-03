package com.evgenii.goncharov.ancient.egypt.features.main.navigation

import androidx.activity.OnBackPressedCallback
import com.github.terrakok.cicerone.Router

class OnBackPressedBottomMenuManager(
    private val bottomMenuRouter: Router
) : OnBackPressedCallback(true) {

    override fun handleOnBackPressed() {
        bottomMenuRouter.exit()
    }
}