package com.evgenii.goncharov.ancient.egypt.features.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.BANNER_TABLE_NAME
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.BannerEntity

@Dao
interface BannerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBanner(banners: List<BannerEntity>)

    @Query("SELECT * FROM $BANNER_TABLE_NAME")
    fun getAllBanners(): List<BannerEntity>
}