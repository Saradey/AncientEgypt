package com.evgenii.goncharov.ancient.egypt.di

import com.evgenii.goncharov.ancient.egypt.use.cases.OnboardingUseCase
import com.evgenii.goncharov.ancient.egypt.use.cases.impl.OnboardingUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCasesBindsModule {

    @Binds
    @Singleton
    fun OnboardingUseCaseImpl.bindOnboardingUseCase(): OnboardingUseCase
}