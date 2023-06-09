package com.evgenii.goncharov.ancient.egypt.features.content.view.models

import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.content.navigation.ContentScreens
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SelectedArticleViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router
) : ViewModel() {

    fun goToTheSelectedArticle() {
        activityRouter.navigateTo(ContentScreens.startSelectedArticle())
    }

    fun goToTheAncientEgyptMapAndArticle() {
        activityRouter.navigateTo(MapScreens.startAncientEgyptMapAndArticle())
    }

    fun goToTheSelectedCategory() {
        activityRouter.navigateTo(ArticlesScreens.startSelectedCategory())
    }

    fun goToTheSelectedPhoto() {
        activityRouter.navigateTo(ContentScreens.startSelectedPhoto())
    }
}