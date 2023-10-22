package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesDatabaseRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesNetworkRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.StoriesDatabaseRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.StoriesNetworkRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesDatabaseUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.StoriesDatabaseUseCaseImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.StoriesNetworkUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
interface StoriesScreenBindsModule {

    @Binds
    fun StoriesNetworkRepositoryImpl.bindStoriesNetworkRepository() : StoriesNetworkRepository

    @Binds
    fun StoriesNetworkUseCaseImpl.bindStoriesNetworkUseCase() : StoriesNetworkUseCase

    @Binds
    fun StoriesDatabaseRepositoryImpl.bindStoriesDatabaseRepository(): StoriesDatabaseRepository

    @Binds
    fun StoriesDatabaseUseCaseImpl.bindStoriesDatabaseUseCase(): StoriesDatabaseUseCase
}