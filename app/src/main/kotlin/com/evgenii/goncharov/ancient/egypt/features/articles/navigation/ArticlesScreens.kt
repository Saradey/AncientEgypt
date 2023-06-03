package com.evgenii.goncharov.ancient.egypt.features.articles.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgenii.goncharov.ancient.egypt.features.articles.AllArticlesFragment
import com.evgenii.goncharov.ancient.egypt.features.articles.FavoriteArticlesFragment
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_ALL
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_FAVORITE
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ArticlesScreens {

    fun startFavoriteArticles() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_FAVORITE
        override fun createFragment(factory: FragmentFactory): Fragment {
            return FavoriteArticlesFragment.newInstance()
        }
    }

    fun startAllArticles() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_ALL
        override fun createFragment(factory: FragmentFactory): Fragment {
            return AllArticlesFragment.newInstance()
        }
    }
}