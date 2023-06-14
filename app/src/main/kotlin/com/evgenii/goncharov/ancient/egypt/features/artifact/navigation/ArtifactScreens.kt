package com.evgenii.goncharov.ancient.egypt.features.artifact.navigation

import com.evgenii.goncharov.ancient.egypt.features.artifact.SelectedArtifactFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ArtifactScreens {

    fun startSelectedArtifact() = FragmentScreen { _ ->
        SelectedArtifactFragment.newInstance()
    }
}