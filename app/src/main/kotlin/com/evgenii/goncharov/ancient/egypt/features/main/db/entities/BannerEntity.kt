package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.evgenii.goncharov.ancient.egypt.consts.ContentType

@Entity(tableName = BANNER_TABLE_NAME)
data class BannerEntity(
    @PrimaryKey @ColumnInfo(name = "banner_id") val bannerId: String,
    @ColumnInfo(name = "content_type") val contentType: ContentType,
    @ColumnInfo(name = "banner_uri") val bannerUri: String,
    @ColumnInfo(name = "banner_description") val bannerDescription: String? = null,
    @ColumnInfo(name = "banner_title") val bannerTitle: String? = null
)

const val BANNER_TABLE_NAME = "banner_table"