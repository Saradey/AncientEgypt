package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.MainContentRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainContentUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.MainContentUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface MainScreenBindsModule {

    @Binds
    fun MainContentRepositoryImpl.bindMainContentRepository(): MainContentRepository

    @Binds
    fun MainContentUseCaseImpl.bindMainContentUseCase(): MainContentUseCase
}