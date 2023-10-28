package com.evgenii.goncharov.ancient.egypt.features.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.PartStoriesEntity

@Dao
interface PartStoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStoriesEntity(entities: List<PartStoriesEntity>)
}