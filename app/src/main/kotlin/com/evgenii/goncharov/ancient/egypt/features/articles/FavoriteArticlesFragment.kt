package com.evgenii.goncharov.ancient.egypt.features.articles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentFavoriteArticlesBinding

/** №4.2 */
class FavoriteArticlesFragment : Fragment(R.layout.fragment_favorite_articles) {

    private val binding: FragmentFavoriteArticlesBinding by viewBinding(
        FragmentFavoriteArticlesBinding::bind
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.title.text = "${binding.title.text}  ${toString()}"
    }

    companion object {
        fun newInstance() = FavoriteArticlesFragment()
    }
}