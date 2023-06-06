package com.evgenii.goncharov.ancient.egypt.features.articles.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgenii.goncharov.ancient.egypt.base.BaseFragmentScreen
import com.evgenii.goncharov.ancient.egypt.features.articles.AllArticlesFragment
import com.evgenii.goncharov.ancient.egypt.features.articles.FavoriteArticlesFragment
import com.evgenii.goncharov.ancient.egypt.features.articles.SelectedCategoryFragment
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_ALL
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_EVERYWHERE
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_FAVORITE
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ArticlesScreens {

    fun startFavoriteArticles() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_FAVORITE,
        baskStackName = BACKSTACK_NAME_FAVORITE
    ) {
        FavoriteArticlesFragment.newInstance()
    }

    fun startAllArticles() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_ALL_ARTICLES,
        baskStackName = BACKSTACK_NAME_ALL
    ) {
        AllArticlesFragment.newInstance()
    }

    fun startSelectedCategory() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_EVERYWHERE
        override fun createFragment(factory: FragmentFactory): Fragment {
            return SelectedCategoryFragment.newInstance()
        }
    }

    const val SCREEN_KEY_FAVORITE = "favorite_screen"
    const val SCREEN_KEY_ALL_ARTICLES = "all_screen"
    const val SCREEN_KEY_SELECTED_CATEGORY = "selected_category_screen"
}