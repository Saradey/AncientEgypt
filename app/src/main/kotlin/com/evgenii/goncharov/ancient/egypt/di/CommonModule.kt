package com.evgenii.goncharov.ancient.egypt.di

import android.os.Build
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CommonModule {

    @Provides
    fun provideBuildVersion() : Int {
        return Build.VERSION.SDK_INT
    }
}