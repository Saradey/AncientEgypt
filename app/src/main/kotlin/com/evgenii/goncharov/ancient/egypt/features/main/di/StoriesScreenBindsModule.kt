package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesNetworkRepository
import com.evgenii.goncharov.ancient.egypt.features.main.repositories.impl.StoriesNetworkRepositoryImpl
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesNetworkUseCase
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl.StoriesNetworkUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface StoriesScreenBindsModule {

    @Binds
    fun StoriesNetworkRepositoryImpl.bindStoriesNetworkRepository() : StoriesNetworkRepository

    @Binds
    fun StoriesNetworkUseCaseImpl.bindStoriesNetworkUseCase() : StoriesNetworkUseCase
}