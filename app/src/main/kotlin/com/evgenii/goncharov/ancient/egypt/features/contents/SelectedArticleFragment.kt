package com.evgenii.goncharov.ancient.egypt.features.contents

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSelectedArticleBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.contents.navigation.ContentScreens
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/**
 * №6.1
 * Doc: https://docs.google.com/document/d/1lPaglQbODCqhaGQ3-UAeGdSE8ltozrNwYwVriCH1Joc/edit
 * */
@AndroidEntryPoint
class SelectedArticleFragment : Fragment(R.layout.fragment_selected_article) {

    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var mainActivityRouter: Router
    private val binding: FragmentSelectedArticleBinding by viewBinding(FragmentSelectedArticleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.title.text = "${binding.title.text} ${toString()}"
        binding.initUi()
    }

    private fun FragmentSelectedArticleBinding.initUi() {
        btnNext1.setOnClickListener {
            mainActivityRouter.navigateTo(ContentScreens.startSelectedArticle())
        }
        btnNext2.setOnClickListener {
            mainActivityRouter.navigateTo(MapScreens.startAncientEgyptMapAndArticle())
        }
        btnNext3.setOnClickListener {
            mainActivityRouter.navigateTo(ArticlesScreens.startSelectedCategory())
        }
        btnNext4.setOnClickListener {
            mainActivityRouter.navigateTo(ContentScreens.startSelectedPhoto())
        }
    }

    companion object {
        fun newInstance() = SelectedArticleFragment()
    }
}