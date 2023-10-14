package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = STORIES_TABLE_NAME)
data class StoriesEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "stories_image") val storiesImage: String,
    @ColumnInfo(name = "stories_title") val storiesTitle: String
)

const val STORIES_TABLE_NAME = "stories"