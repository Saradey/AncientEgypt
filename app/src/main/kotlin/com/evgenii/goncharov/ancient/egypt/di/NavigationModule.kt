package com.evgenii.goncharov.ancient.egypt.di

import com.evgenii.goncharov.ancient.egypt.navigation.OnBackPressedActivityManager
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    @Named(QUALIFIER_ACTIVITY_NAVIGATION)
    fun provideCicerone(): Cicerone<Router> {
        return Cicerone.create()
    }

    @Provides
    @Singleton
    @Named(QUALIFIER_ACTIVITY_NAVIGATION)
    fun provideRouter(@Named(QUALIFIER_ACTIVITY_NAVIGATION) cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

    @Provides
    @Singleton
    @Named(QUALIFIER_ACTIVITY_NAVIGATION)
    fun provideNavigatorHolder(@Named(QUALIFIER_ACTIVITY_NAVIGATION) cicerone: Cicerone<Router>): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Provides
    @Singleton
    fun provideOnBackPressedActivityManager(@Named(QUALIFIER_ACTIVITY_NAVIGATION) mainActivityRouter: Router): OnBackPressedActivityManager {
        return OnBackPressedActivityManager(mainActivityRouter)
    }

    @Provides
    @Singleton
    @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION)
    fun provideBottomMenuCicerone(): Cicerone<Router> {
        return Cicerone.create()
    }

    @Provides
    @Singleton
    @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION)
    fun provideBottomMenuRouter(@Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

    @Provides
    @Singleton
    @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION)
    fun provideBottomMenuNavigatorHolder(@Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) cicerone: Cicerone<Router>): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    const val QUALIFIER_ACTIVITY_NAVIGATION = "ActivityNavigation"
    const val QUALIFIER_BOTTOM_MENU_NAVIGATION = "BottomMenuNavigation"
}