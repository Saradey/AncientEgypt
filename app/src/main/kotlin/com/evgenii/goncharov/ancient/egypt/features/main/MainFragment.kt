package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.contents.navigation.ContentScreens
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.map.navigation.MapScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/**
 * №2.2
 * Doc: https://docs.google.com/document/d/1R1-U1C_VLGf1kwnR2W7SJf_i0znYaJqmfNhZv0G8T5E/edit
 * */
@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    @Inject @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) lateinit var router: Router
    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var mainActivityRouter: Router
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentMainBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
        btnNext1.setOnClickListener {
            mainActivityRouter.navigateTo(MainScreens.startStories())
        }
        btnNext2.setOnClickListener {
            router.navigateTo(ArticlesScreens.startSelectedCategory())
        }
        btnNext3.setOnClickListener {
            mainActivityRouter.navigateTo(ContentScreens.startSelectedArticle())
        }
        btnNext4.setOnClickListener {
            if (true) {
                mainActivityRouter.navigateTo(MapScreens.startAncientEgyptMapAllObjects())
            } else {
                mainActivityRouter.navigateTo(MapScreens.startAncientEgyptMapAndArticle())
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}