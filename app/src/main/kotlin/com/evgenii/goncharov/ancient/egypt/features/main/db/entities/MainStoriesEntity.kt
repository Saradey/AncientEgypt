package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MAIN_STORIES_TABLE_NAME)
data class MainStoriesEntity(
    @PrimaryKey @ColumnInfo(name = "main_stories_id") val mainStoriesId: String,
    @ColumnInfo(name = "main_stories_image") val mainStoriesImage: String,
    @ColumnInfo(name = "main_stories_title") val mainStoriesTitle: String
)

const val MAIN_STORIES_TABLE_NAME = "main_stories_table"