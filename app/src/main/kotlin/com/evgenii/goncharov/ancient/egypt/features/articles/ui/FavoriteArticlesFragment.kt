package com.evgenii.goncharov.ancient.egypt.features.articles.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentFavoriteArticlesBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.content.navigation.ContentScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/**
 * №4.2
 * Doc: https://docs.google.com/document/d/1WPIP7WjD0zpfLLz-d8ZXiHINRX5n5SYOkpx7U3vp3M0/edit
 * */
@AndroidEntryPoint
class FavoriteArticlesFragment : Fragment(R.layout.fragment_favorite_articles) {

    @Inject @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) lateinit var router: Router
    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var mainActivityRouter: Router
    private val binding: FragmentFavoriteArticlesBinding by viewBinding(
        FragmentFavoriteArticlesBinding::bind
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
        binding.title.text = "${binding.title.text}  ${toString()}"
    }

    private fun FragmentFavoriteArticlesBinding.initUi() {
        btnNext1.setOnClickListener {
            router.navigateTo(ArticlesScreens.startSelectedCategory())
        }
        btnNext2.setOnClickListener {
            mainActivityRouter.navigateTo(ContentScreens.startSelectedArticle())
        }
    }

    companion object {
        fun newInstance() = FavoriteArticlesFragment()
    }
}