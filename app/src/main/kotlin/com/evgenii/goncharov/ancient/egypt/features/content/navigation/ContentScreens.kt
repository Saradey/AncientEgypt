package com.evgenii.goncharov.ancient.egypt.features.content.navigation

import com.evgenii.goncharov.ancient.egypt.features.content.fragments.SelectedArticleFragment
import com.evgenii.goncharov.ancient.egypt.features.content.fragments.SelectedPhotoFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ContentScreens {

    fun startSelectedArticle() = FragmentScreen { _ ->
        SelectedArticleFragment.newInstance()
    }

    fun startSelectedPhoto() = FragmentScreen { _ ->
        SelectedPhotoFragment.newInstance()
    }
}