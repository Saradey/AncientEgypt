package com.evgenii.goncharov.ancient.egypt.features.main.view.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evgenii.goncharov.ancient.egypt.base.models.model.BaseModel
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

    fun loadContent() {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _mainContentLiveData.value = MainContentUiState.Error()
        }) {
            _mainContentLiveData.value = MainContentUiState.Loading
            val result = mainContentFromNetworkUseCase()
            _mainContentLiveData.value = createContentState(result)
        }
    }

    private fun createContentState(model: BaseModel<ContentModel>): MainContentUiState {
        return when {
            model.data == null -> MainContentUiState.Error()
            model.status == ResponseStatus.SUCCESS -> MainContentUiState.Content(createContents(model.data))
            model.status == ResponseStatus.ERROR -> MainContentUiState.Error(model.message)
            else -> MainContentUiState.Error()
        }
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