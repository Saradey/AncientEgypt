package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentStoriesBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.contents.navigation.ContentScreens
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/** №2.3 */
@AndroidEntryPoint
class StoriesFragment : Fragment(R.layout.fragment_stories) {

    @Inject @Named(NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION) lateinit var mainActivityRouter: Router
    private val binding: FragmentStoriesBinding by viewBinding(FragmentStoriesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentStoriesBinding.initUi() {
        btnNext1.setOnClickListener {
            mainActivityRouter.navigateTo(ContentScreens.startSelectedArticle())
        }
        btnNext2.setOnClickListener {
            mainActivityRouter.navigateTo(ArticlesScreens.startSelectedCategory())
        }
        btnNext3.setOnClickListener {
            mainActivityRouter.navigateTo(MapScreens.startAncientEgyptMapAndArticle())
        }
    }

    companion object {
        fun newInstance() = StoriesFragment()
    }
}