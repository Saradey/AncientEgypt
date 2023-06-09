package com.evgenii.goncharov.ancient.egypt.features.contents.navigation

import com.evgenii.goncharov.ancient.egypt.features.contents.ui.SelectedArticleFragment
import com.evgenii.goncharov.ancient.egypt.features.contents.ui.SelectedPhotoFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ContentScreens {

    fun startSelectedArticle() = FragmentScreen { _ ->
        SelectedArticleFragment.newInstance()
    }

    fun startSelectedPhoto() = FragmentScreen { _ ->
        SelectedPhotoFragment.newInstance()
    }
}