package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = BANNER_TABLE_NAME)
data class BannerDb(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "content_type") val contentType: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "banner_uri") val bannerUri: String,
    @ColumnInfo(name = "description") val description: String? = null
)

const val BANNER_TABLE_NAME = "banner"