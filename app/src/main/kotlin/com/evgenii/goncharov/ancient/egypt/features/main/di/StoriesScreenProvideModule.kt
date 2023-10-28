package com.evgenii.goncharov.ancient.egypt.features.main.di

import com.evgenii.goncharov.ancient.egypt.db.AppDatabase
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.LinkStoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.PartStoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.StoriesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object StoriesScreenProvideModule {

    @Provides
    @ViewModelScoped
    fun provideStoriesDao(db: AppDatabase) : StoriesDao {
        return db.getStoriesDao()
    }

    @Provides
    @ViewModelScoped
    fun providePartStoriesDao(db: AppDatabase) : PartStoriesDao {
        return db.getPartStoriesDao()
    }

    @Provides
    @ViewModelScoped
    fun provideLinkStoriesDao(db: AppDatabase) : LinkStoriesDao {
        return db.getLinkStoriesDao()
    }
}