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
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    @Provides
    @ActivityScoped
    @Named(QUALIFIER_ACTIVITY_NAVIGATION)
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @ActivityScoped
    @Named(QUALIFIER_ACTIVITY_NAVIGATION)
    fun provideRouter(@Named(QUALIFIER_ACTIVITY_NAVIGATION) cicerone: Cicerone<Router>): Router =
        cicerone.router

    @Provides
    @ActivityScoped
    @Named(QUALIFIER_ACTIVITY_NAVIGATION)
    fun provideNavigatorHolder(@Named(QUALIFIER_ACTIVITY_NAVIGATION) cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.getNavigatorHolder()

    @Provides
    @ActivityScoped
    fun provideOnBackPressedActivityManager(@Named(QUALIFIER_ACTIVITY_NAVIGATION) mainActivityRouter: Router): OnBackPressedActivityManager =
        OnBackPressedActivityManager(mainActivityRouter)

    @Provides
    @ActivityScoped
    @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION)
    fun provideBottomMenuCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @ActivityScoped
    @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION)
    fun provideBottomMenuRouter(@Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) cicerone: Cicerone<Router>): Router =
        cicerone.router

    @Provides
    @ActivityScoped
    @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION)
    fun provideBottomMenuNavigatorHolder(@Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.getNavigatorHolder()

    const val QUALIFIER_ACTIVITY_NAVIGATION = "ActivityNavigation"
    const val QUALIFIER_BOTTOM_MENU_NAVIGATION = "BottomMenuNavigation"
}