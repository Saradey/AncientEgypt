package com.evgenii.goncharov.ancient.egypt.features.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.evgenii.goncharov.ancient.egypt.R

/** №7.1 */
class AncientEgyptMapFragment : Fragment(R.layout.fragment_ancient_egypt_map) {


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