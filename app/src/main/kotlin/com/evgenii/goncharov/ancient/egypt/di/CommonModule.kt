package com.evgenii.goncharov.ancient.egypt.di

import android.content.Context
import android.os.Build
import androidx.room.Room
import com.evgenii.goncharov.ancient.egypt.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CommonModule {

    @Provides
    fun provideBuildVersion(): Int {
        return Build.VERSION.SDK_INT
    }

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "ancient_egypt_db"
        ).build()
    }
}