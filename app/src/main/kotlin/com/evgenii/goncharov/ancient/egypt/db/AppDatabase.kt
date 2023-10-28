package com.evgenii.goncharov.ancient.egypt.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.BannerDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.MapInfoDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.MainStoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.PartStoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.StoriesDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.BannerEntity
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.MapInfoEntity
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.MainStoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.PartStoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity

@Database(
    entities = [
        BannerEntity::class,
        MapInfoEntity::class,
        MainStoriesEntity::class,
        StoriesEntity::class,
        PartStoriesEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getBannerDao(): BannerDao

    abstract fun getMapInfoDao(): MapInfoDao

    abstract fun getMainStoriesDao(): MainStoriesDao

    abstract fun getStoriesDao(): StoriesDao

    abstract fun getPartStoriesDao(): PartStoriesDao
}