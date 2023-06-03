package com.evgenii.goncharov.ancient.egypt.navigation

import androidx.activity.OnBackPressedCallback
import com.github.terrakok.cicerone.Router

class OnBackPressedActivityManager(
    private val mainActivityRouter: Router
) : OnBackPressedCallback(true) {

    override fun handleOnBackPressed() {
        mainActivityRouter.exit()
    }
}