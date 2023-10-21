package com.evgenii.goncharov.ancient.egypt.features.main.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MAP_INFO_TABLE_NAME)
data class MapInfoEntity(
    @PrimaryKey @ColumnInfo(name = "enabled_map") val isEnabledMap: Boolean
)

const val MAP_INFO_TABLE_NAME = "map_info"