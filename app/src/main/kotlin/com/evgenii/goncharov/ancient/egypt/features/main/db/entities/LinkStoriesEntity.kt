package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.evgenii.goncharov.ancient.egypt.consts.ContentType

@Entity(
    tableName = LINK_STORIES_TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = StoriesEntity::class,
            parentColumns = [STORIES_ID_NAME],
            childColumns = [LINK_STORIES_OWNER_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [Index(LINK_STORIES_OWNER_ID)]
)
data class LinkStoriesEntity(
    @PrimaryKey @ColumnInfo(name = "link_id") val linkId: String,
    @ColumnInfo(name = "link_type") val linkType: ContentType,
    @ColumnInfo(name = LINK_STORIES_OWNER_ID) val linkStoriesOwnerId: String,
)

const val LINK_STORIES_TABLE_NAME = "link_stories_table"
const val LINK_STORIES_OWNER_ID = "link_stories_owner_id"