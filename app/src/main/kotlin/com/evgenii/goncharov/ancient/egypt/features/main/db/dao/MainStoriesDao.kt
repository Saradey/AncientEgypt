package com.evgenii.goncharov.ancient.egypt.features.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.MAIN_STORIES_TABLE_NAME
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.MainStoriesEntity

@Dao
interface MainStoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStories(stories: List<MainStoriesEntity>)

    @Query("SELECT * FROM $MAIN_STORIES_TABLE_NAME")
    fun getAllStories(): List<MainStoriesEntity>
}