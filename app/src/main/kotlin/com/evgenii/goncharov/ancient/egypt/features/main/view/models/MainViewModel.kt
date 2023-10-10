package com.evgenii.goncharov.ancient.egypt.features.main.view.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evgenii.goncharov.ancient.egypt.base.models.model.FromNetworkBaseModel
import com.evgenii.goncharov.ancient.egypt.base.utils.ResponseStatus
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.content.navigation.ContentScreens
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BaseContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MapButtonModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.state.MainContentUiState
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainContentFromDbUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainContentFromNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.evgenii.goncharov.ancient.egypt.consts.ContentType
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedBanner
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
    private val mainContentFromNetworkUseCase: MainContentFromNetworkUseCase,
    private val mainContentFromDbUseCase: MainContentFromDbUseCase
) : ViewModel() {

    private val _mainContentLiveData = MutableLiveData<MainContentUiState>()
    val mainContentLiveData: LiveData<MainContentUiState> = _mainContentLiveData

    fun loadContent() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->
            _mainContentLiveData.value = MainContentUiState.Error()
        }) {
            loadFromDb()
            loadFromNetwork()
        }
    }

    fun refreshToUpdate() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->
            _mainContentLiveData.value = MainContentUiState.ErrorUpdate
        }) {
            _mainContentLiveData.value = MainContentUiState.Update
            loadFromNetwork()
        }
    }

    private suspend fun loadFromDb() {
        val contentFromDatabase = mainContentFromDbUseCase()
        if (contentFromDatabase.data.content.isNotEmpty()) {
            _mainContentLiveData.value = MainContentUiState.LoadingUpdateAndContentFromDb(
                createContents(contentFromDatabase.data)
            )
        } else {
            _mainContentLiveData.value = MainContentUiState.Loading
        }
    }

    private suspend fun loadFromNetwork() {
        val result = mainContentFromNetworkUseCase()
        val lastState = _mainContentLiveData.value
        _mainContentLiveData.value = createContentStateFromNetwork(result, lastState)
    }

    private fun createContentStateFromNetwork(
        model: FromNetworkBaseModel<ContentModel>,
        lastState: MainContentUiState?
    ): MainContentUiState {
        return when {
            checkErrorUpdateState(model, lastState) -> MainContentUiState.ErrorUpdate
            model.data == null -> MainContentUiState.Error()
            model.status == ResponseStatus.ERROR -> MainContentUiState.Error(model.message)
            model.status == ResponseStatus.SUCCESS -> MainContentUiState.Content(createContents(model.data))
            else -> MainContentUiState.Error()
        }
    }

    private fun checkErrorUpdateState(
        model: FromNetworkBaseModel<ContentModel>,
        lastState: MainContentUiState?
    ): Boolean {
        return (lastState is MainContentUiState.LoadingUpdateAndContentFromDb ||
                lastState is MainContentUiState.Content) &&
                (model.status == ResponseStatus.ERROR ||
                        model.data == null)
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
}