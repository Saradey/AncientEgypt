package com.evgenii.goncharov.ancient.egypt.features.main.view.models

import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.search.navigation.SearchScreens
import com.evgenii.goncharov.ancient.egypt.features.settings.navigation.SettingsScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainBottomMenuViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
    @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) private val bottomMenuRouter: Router
) : ViewModel() {

    fun goToTheMain() {
        bottomMenuRouter.navigateTo(MainScreens.startMain())
    }

    fun goToTheAllArticles() {
        bottomMenuRouter.navigateTo(ArticlesScreens.startAllArticles())
    }

    fun goToTheFavoriteArticles() {
        bottomMenuRouter.navigateTo(ArticlesScreens.startFavoriteArticles())
    }

    fun goToTheSettings() {
        bottomMenuRouter.navigateTo(SettingsScreens.startSettings())
    }

    fun goToTheSearch() {
        bottomMenuRouter.navigateTo(SearchScreens.startSearch())
    }
}