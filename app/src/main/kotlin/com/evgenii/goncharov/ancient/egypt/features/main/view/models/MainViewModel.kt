package com.evgenii.goncharov.ancient.egypt.features.main.view.models

import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.content.navigation.ContentScreens
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainContentUseCase
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
    @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) private val bottomMenuRouter: Router,
    private val mainContentUseCase: MainContentUseCase
) : ViewModel() {

    fun goToTheStories() {
        activityRouter.navigateTo(MainScreens.startStories())
    }

    fun goToTheSelectedCategory() {
        bottomMenuRouter.navigateTo(ArticlesScreens.startSelectedCategory())
    }

    fun goToTheSelectedArticle() {
        activityRouter.navigateTo(ContentScreens.startSelectedArticle())
    }

    fun goToTheMapAllObjects() {
        bottomMenuRouter.navigateTo(MapScreens.startAncientEgyptMapAllObjects())
    }

    fun goToTheMapSelectedArticle() {
        bottomMenuRouter.navigateTo(MapScreens.startAncientEgyptMapAndArticle())
    }

    fun goToTheSelectedArtifact() {
        activityRouter.navigateTo(ContentScreens.startSelectedArtifact())
    }
}