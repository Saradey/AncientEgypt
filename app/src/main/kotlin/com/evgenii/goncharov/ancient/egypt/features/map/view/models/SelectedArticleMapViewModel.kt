package com.evgenii.goncharov.ancient.egypt.features.map.view.models

import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.contents.navigation.ContentScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SelectedArticleMapViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router
) : ViewModel() {

    fun goToTheSelectedCategory() {
        activityRouter.navigateTo(ArticlesScreens.startSelectedCategory())
    }

    fun gotoTheSelectedArticle() {
        activityRouter.navigateTo(ContentScreens.startSelectedArticle())
    }
}