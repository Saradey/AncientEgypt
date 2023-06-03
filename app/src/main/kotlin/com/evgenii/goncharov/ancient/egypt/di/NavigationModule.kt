package com.evgenii.goncharov.ancient.egypt.di

import com.evgenii.goncharov.ancient.egypt.navigation.OnBackPressedActivityManager
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    @Provides
    @ActivityScoped
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @ActivityScoped
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    @ActivityScoped
    fun provideNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.getNavigatorHolder()

    @Provides
    @ActivityScoped
    fun provideOnBackPressedActivityManager(mainActivityRouter: Router): OnBackPressedActivityManager =
        OnBackPressedActivityManager(mainActivityRouter)
}