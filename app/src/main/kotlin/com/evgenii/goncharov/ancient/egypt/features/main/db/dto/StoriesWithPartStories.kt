package com.evgenii.goncharov.ancient.egypt.features.main.db.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.PartStoriesEntity
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.STORIES_ID_NAME
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.STORIES_OWNER_ID_NAME
import com.evgenii.goncharov.ancient.egypt.features.main.db.entities.StoriesEntity

data class StoriesWithPartStories(
    @Embedded
    val stories: StoriesEntity,
    @Relation(parentColumn = STORIES_ID_NAME, entityColumn = STORIES_OWNER_ID_NAME)
    val partsStories: List<PartStoriesEntity>
)