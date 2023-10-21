package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.network.api.ContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.MainScreenStoriesApi
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.StoriesApi
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.impl.ContentApiImpl
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.impl.MainScreenStoriesApiImpl
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.impl.StoriesApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface MockBindsModule {

    @Binds
    fun ContentApiImpl.bindContentApi(): ContentApi

    @Binds
    fun MainScreenStoriesApiImpl.bindStoriesApi(): MainScreenStoriesApi

    @Binds
    fun StoriesApiImpl.bindMainScreenStoriesApi(): StoriesApi
}