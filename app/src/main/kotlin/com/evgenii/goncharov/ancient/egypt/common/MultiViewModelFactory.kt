package com.evgenii.goncharov.ancient.egypt.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MultiViewModelFactory<T : ViewModel>(
    private val create: () -> T
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return create.invoke() as T
    }
}