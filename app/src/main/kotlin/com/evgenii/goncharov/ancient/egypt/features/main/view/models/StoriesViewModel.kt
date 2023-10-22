package com.evgenii.goncharov.ancient.egypt.features.main.view.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evgenii.goncharov.ancient.egypt.base.models.state.UiState
import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.content.navigation.ContentScreens
import com.evgenii.goncharov.ancient.egypt.features.main.models.dto.request.StoriesModelRequest
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesDatabaseUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class StoriesViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
    private val storiesNetworkUseCase: StoriesNetworkUseCase,
    private val storiesDatabaseUseCase: StoriesDatabaseUseCase
) : ViewModel() {

    private val _storiesState: MutableStateFlow<UiState<StoriesModel>> = MutableStateFlow(UiState.Init)
    val storiesState: StateFlow<UiState<StoriesModel>> = _storiesState
    private var currentStories: String = ""
    private var allStories: MutableList<String> = mutableListOf()

    fun initModel(model: SelectedStoriesModel) {
        currentStories = model.selectedStoriesId
        allStories.addAll(model.allStoriesId)
    }

    fun initStoriesState() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->
            _storiesState.value = UiState.Failure
        }) {
            val modelDatabase = storiesDatabaseUseCase(currentStories)
            modelDatabase.data?.let { model ->
                _storiesState.emit(UiState.Success(model))
            } ?: run {
                _storiesState.emit(UiState.Loading)
                loadStoriesFromNetwork()
            }
        }
    }

    private suspend fun loadStoriesFromNetwork() {
        val networkResponse = storiesNetworkUseCase(StoriesModelRequest(storiesId = currentStories))
        when(networkResponse.status) {
            ResponseStatus.SUCCESS -> {
                networkResponse.data?.let { model ->
                    _storiesState.emit(UiState.Success(model))
                } ?: throw IllegalArgumentException(ERROR_MESSAGE_MODEL_NOT_NULL)
            }
            ResponseStatus.ERROR -> _storiesState.emit(UiState.Failure)
        }
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

    private companion object {
        const val ERROR_MESSAGE_MODEL_NOT_NULL = "Stories must not empty"
    }
}