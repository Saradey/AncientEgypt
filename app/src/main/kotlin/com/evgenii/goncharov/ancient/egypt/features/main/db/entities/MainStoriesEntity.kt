package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MAIN_STORIES_TABLE_NAME)
data class MainStoriesEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "stories_image") val storiesImage: String,
    @ColumnInfo(name = "stories_title") val storiesTitle: String
)

const val MAIN_STORIES_TABLE_NAME = "stories"