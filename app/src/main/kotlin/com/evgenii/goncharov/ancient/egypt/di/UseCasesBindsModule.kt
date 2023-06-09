package com.evgenii.goncharov.ancient.egypt.di

import com.evgenii.goncharov.ancient.egypt.use.cases.OnboardingUseCase
import com.evgenii.goncharov.ancient.egypt.use.cases.impl.OnboardingUseCaseImpl
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCasesBindsModule {

    fun OnboardingUseCaseImpl.bindOnboardingUseCase(): OnboardingUseCase
}