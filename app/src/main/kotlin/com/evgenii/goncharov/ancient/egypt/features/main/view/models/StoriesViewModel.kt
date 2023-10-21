package com.evgenii.goncharov.ancient.egypt.features.main.view.models

import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.content.navigation.ContentScreens
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Named

class StoriesViewModel @AssistedInject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
    @Assisted private val model: SelectedStoriesModel
) : ViewModel() {

    private var currentStories: String = model.selectedStoriesId
    private val allStories: MutableList<String> = model.allStoriesId.toMutableList()

    fun goToTheSelectedArticle() {
        activityRouter.replaceScreen(ContentScreens.startSelectedArticle())
    }

    fun goToTheSelectedCategory() {
        activityRouter.replaceScreen(ArticlesScreens.startSelectedCategoryActivityContainer())
    }

    fun goToTheMapAndArticle() {
        activityRouter.replaceScreen(MapScreens.startAncientEgyptMapAndArticleActivityContainer())
    }

    fun goToTheSelectedArtifact() {
        activityRouter.replaceScreen(ContentScreens.startSelectedArtifact())
    }

    @AssistedFactory
    interface Factory {
        fun create(model: SelectedStoriesModel): StoriesViewModel
    }
}