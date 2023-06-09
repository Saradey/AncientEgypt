package com.evgenii.goncharov.ancient.egypt.features.map.view.models

import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Named

class AncientEgyptMapViewModel @AssistedInject constructor(
    @Assisted private val openArticle: Boolean,
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router
) : ViewModel() {

    fun initStateMap() {
        if (openArticle) {
            goToTheSelectedArticle()
        } else {
            //TODO logic all objects to map
        }
    }

    fun goToTheSelectedArticle() {
        activityRouter.navigateTo(MapScreens.startSelectedBottomSheetArticle())
    }

    @AssistedFactory
    interface Factory {

        fun create(
            @Assisted openArticle: Boolean
        ): AncientEgyptMapViewModel
    }
}