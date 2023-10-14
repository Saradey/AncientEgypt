package com.evgenii.goncharov.ancient.egypt.features.main.view.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseStatusModel
import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.content.navigation.ContentScreens
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BaseContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MapButtonModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.state.ContentUiState
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.ContentFromDatabaseUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.ContentFromNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.evgenii.goncharov.ancient.egypt.consts.ContentType
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedBanner
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.state.StoriesUiState
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesFromDatabaseUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesFromNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.search.navigation.SearchScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
    @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) private val bottomMenuRouter: Router,
    private val mainContentFromNetworkUseCase: ContentFromNetworkUseCase,
    private val mainContentFromDbUseCase: ContentFromDatabaseUseCase,
    private val storiesFromDatabaseUseCase: StoriesFromDatabaseUseCase,
    private val storiesFromNetworkUseCase: StoriesFromNetworkUseCase
) : ViewModel() {

    private val _contentLiveData = MutableLiveData<ContentUiState>()
    val contentLiveData: LiveData<ContentUiState> = _contentLiveData
    private val _storiesLiveData = MutableLiveData<StoriesUiState>()
    val storiesLiveData: LiveData<StoriesUiState> = _storiesLiveData

    fun loadContent() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->
            _contentLiveData.value = getCorrectState()
        }) {
            loadContentFromDb()
            loadContentFromNetwork()
        }
    }

    fun refreshToUpdate() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->
            _contentLiveData.value = ContentUiState.ErrorUpdate
        }) {
            _contentLiveData.value = ContentUiState.Update(
                _contentLiveData.value is ContentUiState.Error
            )
            loadContentFromNetwork()
        }
    }

    fun bannerClick(model: SelectedBanner) {
        when (ContentType.valueOf(model.contentType.uppercase())) {
            ContentType.ARTICLE -> goToTheSelectedArticle(model.id)
            ContentType.ARTICLE_MAP -> goToTheMapSelectedArticle(model.id)
            ContentType.CATEGORY -> goToTheSelectedCategory(model.id)
            ContentType.ARTIFACT -> goToTheSelectedArtifact(model.id)
        }
    }

    fun goToTheStories() {
        activityRouter.navigateTo(MainScreens.startStories())
    }

    fun goToTheSelectedCategory(idSelectedCategory: String) {
        bottomMenuRouter.navigateTo(ArticlesScreens.startSelectedCategory())
    }

    fun goToTheSelectedArticle(idSelectedArticle: String) {
        activityRouter.navigateTo(ContentScreens.startSelectedArticle())
    }

    fun goToTheMapAllObjects() {
        bottomMenuRouter.navigateTo(MapScreens.startAncientEgyptMapAllObjects())
    }

    private fun goToTheMapSelectedArticle(idSelectedArticle: String) {
        bottomMenuRouter.navigateTo(MapScreens.startAncientEgyptMapAndArticle())
    }

    fun goToTheSelectedArtifact(idSelectedArtifact: String) {
        activityRouter.navigateTo(ContentScreens.startSelectedArtifact())
    }

    fun goToTheSearchScreen() {
        bottomMenuRouter.navigateTo(SearchScreens.startSearch())
    }

    fun loadStories() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->

        }) {
            loadStoriesFromDatabase()
            loadStoriesFromNetwork()
        }
    }

    private suspend fun loadStoriesFromDatabase() {
        val storiesFromDatabase = storiesFromDatabaseUseCase()
        if (storiesFromDatabase.data.isNotEmpty()) {
            setStoriesState(storiesFromDatabase.data)
        } else {
            _storiesLiveData.value = StoriesUiState.Loading
        }
    }

    private suspend fun loadStoriesFromNetwork() {
        val result = storiesFromNetworkUseCase()
        when (result.status) {
            ResponseStatus.ERROR -> setStatusError()
            ResponseStatus.SUCCESS -> setStoriesState(result.data)
        }
    }

    private fun setStatusError() {
        val lastStoriesState = _storiesLiveData.value
        if (lastStoriesState == StoriesUiState.Error ||
            lastStoriesState == StoriesUiState.Loading ||
            lastStoriesState == StoriesUiState.HideStories) {
            _storiesLiveData.value = StoriesUiState.HideStories
        }
    }

    private fun setStoriesState(models: List<StoriesModel>?) {
        models?.let {
            _storiesLiveData.value = StoriesUiState.Stories(models)
        } ?: run {
            _storiesLiveData.value = StoriesUiState.HideStories
        }
    }

    private fun getCorrectState(): ContentUiState {
        val lastState = _contentLiveData.value
        return if (checkLastState(lastState)) {
            ContentUiState.ErrorUpdate
        } else {
            ContentUiState.Error()
        }
    }

    private suspend fun loadContentFromDb() {
        val contentFromDatabase = mainContentFromDbUseCase()
        if (contentFromDatabase.data.content.isNotEmpty()) {
            _contentLiveData.value = ContentUiState.UpdateAndOldContent(
                createContents(contentFromDatabase.data)
            )
        } else {
            _contentLiveData.value = ContentUiState.Loading
        }
    }

    private suspend fun loadContentFromNetwork() {
        val result = mainContentFromNetworkUseCase()
        val lastState = _contentLiveData.value
        _contentLiveData.postValue(createContentStateFromNetwork(result, lastState))
    }

    private fun createContentStateFromNetwork(
        model: BaseStatusModel<ContentModel>,
        lastState: ContentUiState?
    ): ContentUiState {
        return when {
            model.status == ResponseStatus.ERROR || model.data == null -> {
                createErrorState(model, lastState)
            }
            model.status == ResponseStatus.SUCCESS -> {
                ContentUiState.Content(createContents(model.data))
            }
            else -> ContentUiState.Error()
        }
    }

    private fun createErrorState(
        model: BaseStatusModel<ContentModel>,
        lastState: ContentUiState?
    ): ContentUiState {
        return if (checkLastState(lastState)) {
            ContentUiState.ErrorUpdate
        } else {
            ContentUiState.Error(model.message)
        }
    }

    private fun checkLastState(lastState: ContentUiState?): Boolean {
        return lastState is ContentUiState.UpdateAndOldContent ||
                lastState is ContentUiState.Content ||
                (lastState is ContentUiState.Update && !lastState.isErrorStateBefore)
    }

    private fun createContents(model: ContentModel): List<BaseContentModel> {
        return model.content.let { models ->
            if (model.isEnabledMap && models.isNotEmpty()) {
                models.toMutableList<BaseContentModel>().apply {
                    add(0, MapButtonModel)
                }
            } else {
                models
            }
        }
    }
}