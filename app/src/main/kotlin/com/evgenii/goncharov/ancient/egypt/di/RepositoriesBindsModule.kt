package com.evgenii.goncharov.ancient.egypt.di

import com.evgenii.goncharov.ancient.egypt.features.splash.repositories.OnboardingRepository
import com.evgenii.goncharov.ancient.egypt.features.splash.repositories.impl.OnboardingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesBindsModule {

    @Binds
    @Singleton
    fun OnboardingRepositoryImpl.bindOnboardingRepository(): OnboardingRepository
}