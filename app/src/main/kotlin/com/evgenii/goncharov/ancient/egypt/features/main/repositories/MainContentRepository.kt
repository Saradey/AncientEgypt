package com.evgenii.goncharov.ancient.egypt.features.main.repositories

import com.evgenii.goncharov.ancient.egypt.base.models.entities.BaseEntity
import com.evgenii.goncharov.ancient.egypt.features.main.models.entities.ContentEntity

interface MainContentRepository {

    suspend operator fun invoke(): BaseEntity<ContentEntity>
}