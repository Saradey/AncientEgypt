package com.evgenii.goncharov.ancient.egypt.features.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSearchBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.contents.navigation.ContentScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/**
 * №3
 * Doc: https://docs.google.com/document/d/1ts5R-XO3gCcr-_6CGfXUvGNQX6AKPv_WBIPwvN2U4YU/edit
 * */
@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    @Inject @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) lateinit var router: Router
    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var mainActivityRouter: Router
    private val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentSearchBinding.initUi() {
        btnNext1.setOnClickListener {
            router.navigateTo(ArticlesScreens.startSelectedCategory())
        }
        btnNext2.setOnClickListener {
            mainActivityRouter.navigateTo(ContentScreens.startSelectedArticle())
        }
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}