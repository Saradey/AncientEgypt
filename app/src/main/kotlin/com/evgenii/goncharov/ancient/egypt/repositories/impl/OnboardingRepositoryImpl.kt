package com.evgenii.goncharov.ancient.egypt.repositories.impl

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.evgenii.goncharov.ancient.egypt.repositories.OnboardingRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor(
    @ApplicationContext private val appContext: Context
) : OnboardingRepository {

    override fun isFirstStartOnboarding(): Boolean {
        val pref = appContext.getSharedPreferences(PREF_ONBOARDING_INFO, MODE_PRIVATE)
        return pref.getBoolean(KEY_IS_FIRST_START_ONBOARDING, true)
    }

    companion object {
        private const val PREF_ONBOARDING_INFO = "PREF_ONBOARDING_INFO"
        private const val KEY_IS_FIRST_START_ONBOARDING = "KEY_IS_FIRST_START_ONBOARDING"
    }
}