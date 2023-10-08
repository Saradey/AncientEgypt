package com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.features.main.repositories.MainContentFromDbRepository
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.MainContentFromDbUseCase
import javax.inject.Inject

class MainContentFromDbUseCaseImpl @Inject constructor(
    private val mainContentFromDbRepository: MainContentFromDbRepository
) : MainContentFromDbUseCase {

}
