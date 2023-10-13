package com.evgenii.goncharov.ancient.egypt.features.main.repositories

fun interface StoriesFromDatabaseRepository {

    suspend operator fun invoke()
}