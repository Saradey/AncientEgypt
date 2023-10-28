package com.evgenii.goncharov.ancient.egypt.features.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.evgenii.goncharov.ancient.egypt.features.main.db.dto.StoriesWithPartStories
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.STORIES_TABLE_NAME
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity

@Dao
interface StoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStories(entity: StoriesEntity)

    @Transaction
    @Query("SELECT * FROM $STORIES_TABLE_NAME WHERE stories_id = :storiesId")
    fun getStoriesWithPartStories(storiesId: String): StoriesWithPartStories
}