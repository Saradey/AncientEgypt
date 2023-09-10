package com.evgenii.goncharov.ancient.egypt.features.splash.view.models

import androidx.lifecycle.ViewModel
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.splash.models.OnboardingModel
import com.evgenii.goncharov.ancient.egypt.features.splash.repositories.OnboardingModelFactory
import com.evgenii.goncharov.ancient.egypt.repositories.OnboardingRepository
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    @Named(QUALIFIER_ACTIVITY_NAVIGATION) private val activityRouter: Router,
    private val onboardingRepository: OnboardingRepository,
    private val onboardingModelFactory: OnboardingModelFactory
) : ViewModel() {

    val onboardingInfo: StateFlow<List<OnboardingModel>> =
        MutableStateFlow(onboardingModelFactory.createModels())

    fun goToTheMainBottomMenu() {
        activityRouter.replaceScreen(MainScreens.startMainBottomMenu())
        onboardingRepository.onboardingFinish()
    }
}