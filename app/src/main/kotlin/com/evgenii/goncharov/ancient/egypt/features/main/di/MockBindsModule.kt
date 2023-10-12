package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.features.main.network.api.MainContentApi
import com.evgenii.goncharov.ancient.egypt.features.main.network.api.impl.MainContentApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface MockBindsModule {

    @Binds
    fun MainContentApiImpl.bindMainContentApi(): MainContentApi
}