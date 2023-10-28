package com.evgenii.goncharov.ancient.egypt.features.main.db.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.PartStoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity

data class StoriesWithPartStories(
    @Embedded
    val stories: StoriesEntity,
    @Relation(parentColumn = "stories_id", entityColumn = "stories_owner_id")
    val partsStories: List<PartStoriesEntity>
)