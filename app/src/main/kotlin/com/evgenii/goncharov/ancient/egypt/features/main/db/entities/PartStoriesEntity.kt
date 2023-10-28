package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = PARTS_STORIES_TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = StoriesEntity::class,
            parentColumns = ["stories_id"],
            childColumns = ["stories_owner_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [Index("stories_owner_id")]
)
data class PartStoriesEntity(
    @PrimaryKey @ColumnInfo(name = "parts_stories_id") val partsStoriesId: String,
    @ColumnInfo(name = "stories_owner_id") val storiesOwnerId: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "title_color") val titleColor: Long?,
    @ColumnInfo(name = "description_color") val descriptionColor: Long?,
    @ColumnInfo(name = "uri_content") val uriContent: String,
)

const val PARTS_STORIES_TABLE_NAME = "part_stories_table"