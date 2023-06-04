package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.navigation.OnBackPressedBottomMenuManager
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object MainNavigationModule {

    @Provides
    @FragmentScoped
    fun provideOnBackPressedBottomMenuManager(@Named("BottomMenu") router: Router): OnBackPressedBottomMenuManager =
        OnBackPressedBottomMenuManager(router)
}