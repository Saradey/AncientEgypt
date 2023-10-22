package com.evgenii.goncharov.ancient.egypt.features.main.view.models

import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.content.navigation.ContentScreens
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesDatabaseUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class StoriesViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
    private val storiesNetworkUseCase: StoriesNetworkUseCase,
    private val storiesDatabaseUseCase: StoriesDatabaseUseCase
) : ViewModel() {

    private var currentStories: String = ""
    private var allStories: MutableList<String> = mutableListOf()

    fun initStoriesState() {

    }

    fun initModel(model: SelectedStoriesModel) {
        currentStories = model.selectedStoriesId
        allStories.addAll(model.allStoriesId)
    }

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
}