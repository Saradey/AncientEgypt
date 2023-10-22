package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.db.AppDatabase
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.BannerDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.MapInfoDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.MainStoriesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MainScreenProvideModule {

    @Provides
    @ViewModelScoped
    fun provideBannerDao(db: AppDatabase): BannerDao {
        return db.getBannerDao()
    }

    @Provides
    @ViewModelScoped
    fun provideMapInfoDao(db: AppDatabase): MapInfoDao {
        return db.getMapInfoDao()
    }

    @Provides
    @ViewModelScoped
    fun provideStoriesDao(db: AppDatabase): MainStoriesDao {
        return db.getStoriesDao()
    }
}