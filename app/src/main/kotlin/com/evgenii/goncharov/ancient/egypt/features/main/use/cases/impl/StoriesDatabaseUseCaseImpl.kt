package com.evgenii.goncharov.ancient.egypt.features.main.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.features.main.repositories.StoriesDatabaseRepository
import com.evgenii.goncharov.ancient.egypt.features.main.use.cases.StoriesDatabaseUseCase
import javax.inject.Inject

class StoriesDatabaseUseCaseImpl @Inject constructor(
    private val storiesDatabaseRepository: StoriesDatabaseRepository
) : StoriesDatabaseUseCase {

}