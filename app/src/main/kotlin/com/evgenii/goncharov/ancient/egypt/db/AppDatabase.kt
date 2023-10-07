package com.evgenii.goncharov.ancient.egypt.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.evgenii.goncharov.ancient.egypt.features.main.db.dao.BannerDao
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.BannerDb

@Database(
    entities = [BannerDb::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getBannerDao(): BannerDao
}