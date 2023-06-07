package com.evgenii.goncharov.ancient.egypt.features.map

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.BottomSheetSelectedArticleBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.contents.navigation.ContentScreens
import com.github.terrakok.cicerone.Router
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/** №7.2 */
@AndroidEntryPoint
class SelectedArticleMapBottomSheetFragment : BottomSheetDialogFragment(
    R.layout.bottom_sheet_selected_article
) {

    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var mainActivityRouter: Router
    private val binding: BottomSheetSelectedArticleBinding by viewBinding(BottomSheetSelectedArticleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun BottomSheetSelectedArticleBinding.initUi() {
        btnNext1.setOnClickListener {
            mainActivityRouter.navigateTo(ArticlesScreens.startSelectedCategory())
            dismiss()
        }
        btnNext2.setOnClickListener {
            mainActivityRouter.navigateTo(ContentScreens.startSelectedArticle())
            dismiss()
        }
    }

    companion object {
        fun newInstance() = SelectedArticleMapBottomSheetFragment()
    }
}