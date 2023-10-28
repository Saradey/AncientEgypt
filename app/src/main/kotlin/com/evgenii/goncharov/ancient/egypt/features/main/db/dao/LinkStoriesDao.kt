package com.evgenii.goncharov.ancient.egypt.features.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.LINK_STORIES_OWNER_ID
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.LINK_STORIES_TABLE_NAME
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.LinkStoriesEntity

@Dao
interface LinkStoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLinkStories(entity: LinkStoriesEntity)

    @Query("SELECT * FROM $LINK_STORIES_TABLE_NAME WHERE $LINK_STORIES_OWNER_ID = :storiesId")
    fun getLinkStoriesByStoriesId(storiesId: String) : LinkStoriesEntity?
}