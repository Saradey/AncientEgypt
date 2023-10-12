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
    private val mainContentFromDbUseCase: ContentFromDatabaseUseCase
) : ViewModel() {

    private val _mainContentLiveData = MutableLiveData<ContentUiState>()
    val mainContentLiveData: LiveData<ContentUiState> = _mainContentLiveData

    fun loadContent() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->
            _mainContentLiveData.value = getCorrectState()
        }) {
            loadFromDb()
            loadFromNetwork()
        }
    }

    fun refreshToUpdate() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->
            _mainContentLiveData.value = ContentUiState.ErrorUpdate
        }) {
            _mainContentLiveData.value = ContentUiState.Update(
                _mainContentLiveData.value is ContentUiState.Error
            )
            loadFromNetwork()
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

    private fun getCorrectState(): ContentUiState {
        val lastState = _mainContentLiveData.value
        return if (checkLastState(lastState)) {
            ContentUiState.ErrorUpdate
        } else {
            ContentUiState.Error()
        }
    }

    private suspend fun loadFromDb() {
        val contentFromDatabase = mainContentFromDbUseCase()
        if (contentFromDatabase.data.content.isNotEmpty()) {
            _mainContentLiveData.value = ContentUiState.UpdateAndOldContent(
                createContents(contentFromDatabase.data)
            )
        } else {
            _mainContentLiveData.value = ContentUiState.Loading
        }
    }

    private suspend fun loadFromNetwork() {
        val result = mainContentFromNetworkUseCase()
        val lastState = _mainContentLiveData.value
        _mainContentLiveData.postValue(createContentStateFromNetwork(result, lastState))
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