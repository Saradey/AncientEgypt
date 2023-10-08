package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentFromNetworkRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.MainContentFromNetworkRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainContentFromNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.MainContentFromNetworkUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface MainScreenBindsModule {

    @Binds
    fun MainContentFromNetworkRepositoryImpl.bindMainContentRepository(): MainContentFromNetworkRepository

    @Binds
    fun MainContentFromNetworkUseCaseImpl.bindMainContentUseCase(): MainContentFromNetworkUseCase
}