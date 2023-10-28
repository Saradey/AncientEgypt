package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = LINK_STORIES_TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = StoriesEntity::class,
            parentColumns = [STORIES_ID_NAME],
            childColumns = ["stories_owner_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [Index("stories_owner_id")]
)
data class LinkStoriesEntity(
    @PrimaryKey @ColumnInfo(name = "link_id") val linkId: String,
    @ColumnInfo(name = "link_type") val linkType: String,
    @ColumnInfo(name = "stories_owner_id") val storiesOwnerId: String,
)

const val LINK_STORIES_TABLE_NAME = "link_stories_table"