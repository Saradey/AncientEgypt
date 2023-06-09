package com.evgenii.goncharov.ancient.egypt.use.cases.impl

import com.evgenii.goncharov.ancient.egypt.repositories.OnboardingRepository
import com.evgenii.goncharov.ancient.egypt.use.cases.OnboardingUseCase
import javax.inject.Inject

class OnboardingUseCaseImpl @Inject constructor(
    private val onboardingRepository: OnboardingRepository
) : OnboardingUseCase {
}