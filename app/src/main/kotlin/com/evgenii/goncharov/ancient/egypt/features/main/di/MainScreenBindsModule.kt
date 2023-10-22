package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.repositories.ContentFromDatabaseRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.ContentFromNetworkRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainStoriesFromDatabaseRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainStoriesFromNetworkRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.ContentFromDatabaseRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.ContentFromNetworkRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.MainStoriesFromDatabaseRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.MainStoriesFromNetworkRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.ContentDatabaseUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.ContentNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainStoriesDatabaseUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainStoriesNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.ContentFromDatabaseUseCaseImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.ContentFromNetworkUseCaseImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.StoriesFromDatabaseUseCaseImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.StoriesFromNetworkUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface MainScreenBindsModule {

    @Binds
    fun ContentFromNetworkRepositoryImpl.bindContentFromNetworkRepository(): ContentFromNetworkRepository

    @Binds
    fun ContentFromNetworkUseCaseImpl.bindContentFromNetworkUseCase(): ContentNetworkUseCase

    @Binds
    fun ContentFromDatabaseRepositoryImpl.bindContentFromDatabaseRepository(): ContentFromDatabaseRepository

    @Binds
    fun ContentFromDatabaseUseCaseImpl.bindContentFromDatabaseUseCase(): ContentDatabaseUseCase

    @Binds
    fun MainStoriesFromDatabaseRepositoryImpl.bindStoriesFromDatabaseRepository(): MainStoriesFromDatabaseRepository

    @Binds
    fun StoriesFromDatabaseUseCaseImpl.bindStoriesFromDatabaseUseCase(): MainStoriesDatabaseUseCase

    @Binds
    fun MainStoriesFromNetworkRepositoryImpl.bindStoriesFromNetworkRepository(): MainStoriesFromNetworkRepository

    @Binds
    fun StoriesFromNetworkUseCaseImpl.bindStoriesFromNetworkUseCase(): MainStoriesNetworkUseCase
}