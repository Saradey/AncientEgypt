package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.repositories.ContentFromDatabaseRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.ContentFromNetworkRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.ContentFromDatabaseRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.ContentFromNetworkRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.ContentFromDatabaseUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.ContentFromNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.ContentFromDatabaseUseCaseImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.ContentFromNetworkUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface MainScreenBindsModule {

    @Binds
    fun ContentFromNetworkRepositoryImpl.bindMainContentRepository(): ContentFromNetworkRepository

    @Binds
    fun ContentFromNetworkUseCaseImpl.bindMainContentUseCase(): ContentFromNetworkUseCase

    @Binds
    fun ContentFromDatabaseRepositoryImpl.bindMainContentFromDbRepository(): ContentFromDatabaseRepository

    @Binds
    fun ContentFromDatabaseUseCaseImpl.MainContentFromDbUseCase(): ContentFromDatabaseUseCase
}