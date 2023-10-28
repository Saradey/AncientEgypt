package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.evgenii.goncharov.ancient.egypt.features.main.models.consts.StoriesContentType

@Entity(
    tableName = PARTS_STORIES_TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = StoriesEntity::class,
            parentColumns = [STORIES_ID_NAME],
            childColumns = [STORIES_OWNER_ID_NAME],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [Index(STORIES_OWNER_ID_NAME)]
)
data class PartStoriesEntity(
    @PrimaryKey @ColumnInfo(name = "parts_stories_id") val partsStoriesId: String,
    @ColumnInfo(name = STORIES_OWNER_ID_NAME) val storiesOwnerId: String,
    @ColumnInfo(name = "part_stories_type") val type: StoriesContentType,
    @ColumnInfo(name = "part_stories_title") val title: String?,
    @ColumnInfo(name = "part_stories_description") val description: String?,
    @ColumnInfo(name = "part_stories_title_color") val titleColor: Long?,
    @ColumnInfo(name = "part_stories_description_color") val descriptionColor: Long?,
    @ColumnInfo(name = "part_stories_uri_content") val uriContent: String,
)

const val PARTS_STORIES_TABLE_NAME = "part_stories_table"
const val STORIES_OWNER_ID_NAME = "stories_owner_id"