package com.evgenii.goncharov.ancient.egypt.features.articles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSelectedCategoryBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.contents.navigation.ContentScreens
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/** №4.3 */
@AndroidEntryPoint
class SelectedCategoryFragment : Fragment(R.layout.fragment_selected_category) {

    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var mainActivityRouter: Router
    private val binding: FragmentSelectedCategoryBinding by viewBinding(
        FragmentSelectedCategoryBinding::bind
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.title.text = "${binding.title.text} ${toString()}"
        binding.initUi()
    }

    private fun FragmentSelectedCategoryBinding.initUi() {
        btnNext1.setOnClickListener {
            mainActivityRouter.navigateTo(ContentScreens.startSelectedArticle())
        }
    }

    companion object {
        fun newInstance() = SelectedCategoryFragment()
    }
}