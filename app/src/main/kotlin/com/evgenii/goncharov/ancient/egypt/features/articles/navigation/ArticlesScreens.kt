package com.evgenii.goncharov.ancient.egypt.features.articles.navigation

import com.evgenii.goncharov.ancient.egypt.base.BaseFragmentScreen
import com.evgenii.goncharov.ancient.egypt.features.articles.fragments.AllArticlesFragment
import com.evgenii.goncharov.ancient.egypt.features.articles.fragments.FavoriteArticlesFragment
import com.evgenii.goncharov.ancient.egypt.features.articles.fragments.SelectedCategoryFragment
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_ALL
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_EVERYWHERE
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_FAVORITE
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ArticlesScreens {

    /**
     * Navigation bottom menu container
     */
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

    fun startSelectedCategory() = BaseFragmentScreen(
        screenKey = SCREEN_KEY_SELECTED_CATEGORY,
        baskStackName = BACKSTACK_NAME_EVERYWHERE
    ) {
        SelectedCategoryFragment.newInstance()
    }

    /**
     * Navigation activity container
     */
    fun startSelectedCategoryActivityContainer() = FragmentScreen { _ ->
        SelectedCategoryFragment.newInstance()
    }

    private const val SCREEN_KEY_FAVORITE = "favorite_screen"
    const val SCREEN_KEY_ALL_ARTICLES = "all_screen"
    private const val SCREEN_KEY_SELECTED_CATEGORY = "selected_category_screen"
}