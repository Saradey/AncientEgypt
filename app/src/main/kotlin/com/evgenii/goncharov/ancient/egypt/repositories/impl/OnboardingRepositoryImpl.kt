package com.evgenii.goncharov.ancient.egypt.repositories.impl

import com.evgenii.goncharov.ancient.egypt.repositories.OnboardingRepository
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor() : OnboardingRepository {

    override fun isFirstStartOnboarding(): Boolean {
        return false
    }

    companion object {

    }
}