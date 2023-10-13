package com.evgenii.goncharov.ancient.egypt.features.main.repositories

fun interface StoriesFromNetworkRepository {

    suspend operator fun invoke()
}