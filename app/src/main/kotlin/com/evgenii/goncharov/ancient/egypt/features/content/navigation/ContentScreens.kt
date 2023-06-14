package com.evgenii.goncharov.ancient.egypt.features.content.navigation

import com.evgenii.goncharov.ancient.egypt.features.content.fragments.SelectedArticleFragment
import com.evgenii.goncharov.ancient.egypt.features.content.fragments.SelectedArtifactFragment
import com.evgenii.goncharov.ancient.egypt.features.content.fragments.SelectedPhotoFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ContentScreens {

    /**
     * Navigation activity container
     */
    fun startSelectedArticle() = FragmentScreen { _ ->
        SelectedArticleFragment.newInstance()
    }

    fun startSelectedPhoto() = FragmentScreen { _ ->
        SelectedPhotoFragment.newInstance()
    }

    fun startSelectedArtifact() = FragmentScreen { _ ->
        SelectedArtifactFragment.newInstance()
    }
}