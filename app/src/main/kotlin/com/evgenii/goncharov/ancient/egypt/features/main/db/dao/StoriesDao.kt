package com.evgenii.goncharov.ancient.egypt.features.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity

@Dao
interface StoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStories(entity: StoriesEntity)

//    @Query("SELECT * FROM $STORIES_TABLE_NAME WHERE stories_id =:storiesId")
//    fun getStoriesEntityById(storiesId: String) : StoriesEntity

//    @Transaction
//    @Query("SELECT * FROM $STORIES_TABLE_NAME WHERE stories_id = :storiesId")
//    fun getStoriesWithPartStories(storiesId: String): StoriesWithPartStories
}