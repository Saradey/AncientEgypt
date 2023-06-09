package com.evgenii.goncharov.ancient.egypt.repositories.utils

import android.os.Build
import com.evgenii.goncharov.ancient.egypt.repositories.OnboardingRepository


fun OnboardingRepository.isStartOnboarding(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && isFirstStartOnboarding()
}

fun OnboardingRepository.isStartBottomMenu(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && !isFirstStartOnboarding()
}