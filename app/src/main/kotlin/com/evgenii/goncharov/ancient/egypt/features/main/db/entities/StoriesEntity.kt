package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = STORIES_TABLE_NAME)
data class StoriesEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "title_color") val titleColor: Int,
    @ColumnInfo(name = "description_color") val descriptionColor: Int,
    @ColumnInfo(name = "uri_content") val uriContent: String,
    @ColumnInfo(name = "link_id") val linkId: String,
    @ColumnInfo(name = "link_type") val linkType: String
)

const val STORIES_TABLE_NAME = "stories"