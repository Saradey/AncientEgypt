package com.evgenii.goncharov.ancient.egypt.features.contents.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgenii.goncharov.ancient.egypt.features.contents.SelectedArticleFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ContentScreens {

    fun startSelectedArticle() = object : FragmentScreen{
        override fun createFragment(factory: FragmentFactory): Fragment {
            return SelectedArticleFragment.newInstance()
        }
    }
}