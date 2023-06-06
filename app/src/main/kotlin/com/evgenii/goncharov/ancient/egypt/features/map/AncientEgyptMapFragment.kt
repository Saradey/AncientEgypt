package com.evgenii.goncharov.ancient.egypt.features.map

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentAncientEgyptMapBinding

/** №7.1 */
class AncientEgyptMapFragment : Fragment(R.layout.fragment_ancient_egypt_map) {

    private val binding: FragmentAncientEgyptMapBinding by viewBinding(FragmentAncientEgyptMapBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUi()
    }

    private fun initUi() {
        val openArticleToBottomSheet =
            arguments?.getBoolean(OPEN_ARTICLE_BOTTOM_SHEET_KEY, false) ?: false
        if(openArticleToBottomSheet) {
            startArticleBottomSheet()
        } else {
            //TODO logic all objects to map
        }
    }

    private fun startArticleBottomSheet() {

    }

    companion object {

        fun newInstance(openArticleToBottomSheet: Boolean): Fragment {
            val fragment = AncientEgyptMapFragment()
            fragment.arguments = Bundle().apply {
                putBoolean(OPEN_ARTICLE_BOTTOM_SHEET_KEY, openArticleToBottomSheet)
            }
            return fragment
        }

        private const val OPEN_ARTICLE_BOTTOM_SHEET_KEY = "OPEN_ARTICLE_BOTTOM_SHEET_KEY"
    }
}