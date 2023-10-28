package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = LINK_STORIES_TABLE_NAME)
data class LinkStoriesEntity(
    @ColumnInfo(name = "link_id") val linkId: String,
    @ColumnInfo(name = "link_type") val linkType: String
)

const val LINK_STORIES_TABLE_NAME = "link_stories_table"