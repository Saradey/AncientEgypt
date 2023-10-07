package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.api.MainContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.api.impl.MainContentApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
interface MockBindsModule {

    @Binds
    fun MainContentApiImpl.bindMainContentApi(): MainContentApi
}