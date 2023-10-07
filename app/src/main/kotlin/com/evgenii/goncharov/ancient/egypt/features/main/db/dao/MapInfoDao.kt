package com.evgenii.goncharov.ancient.egypt.features.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.MAP_INFO_TABLE_NAME
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.MapInfoEntity

@Dao
interface MapInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMapInfoEntity(entity: MapInfoEntity)

    @Query("SELECT * FROM $MAP_INFO_TABLE_NAME")
    fun getMapInfo(): List<MapInfoEntity>
}