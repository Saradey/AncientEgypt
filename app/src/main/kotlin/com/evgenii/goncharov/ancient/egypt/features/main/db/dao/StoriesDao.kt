package com.evgenii.goncharov.ancient.egypt.features.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.STORIES_TABLE_NAME
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity

@Dao
interface StoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStoriesEntity(entity: StoriesEntity)

    @Query("SELECT * FROM $STORIES_TABLE_NAME WHERE id =:storiesId")
    fun getStoriesEntityById(storiesId: String) : StoriesEntity
}