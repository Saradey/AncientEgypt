package com.evgenii.goncharov.ancient.egypt.features.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.LinkStoriesEntity

@Dao
interface LinkStoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLinkStories(entity : LinkStoriesEntity)
}