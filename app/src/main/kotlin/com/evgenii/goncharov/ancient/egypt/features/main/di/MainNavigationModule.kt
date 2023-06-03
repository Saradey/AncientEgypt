package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.navigation.OnBackPressedBottomMenuManager
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
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
    @Named("BottomMenu")
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @FragmentScoped
    @Named("BottomMenu")
    fun provideRouter(@Named("BottomMenu") cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    @FragmentScoped
    @Named("BottomMenu")
    fun provideNavigatorHolder(@Named("BottomMenu") cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.getNavigatorHolder()

    @Provides
    @FragmentScoped
    @Named("BottomMenu")
    fun provideOnBackPressedBottomMenuManager(@Named("BottomMenu") router: Router): OnBackPressedBottomMenuManager =
        OnBackPressedBottomMenuManager(router)
}