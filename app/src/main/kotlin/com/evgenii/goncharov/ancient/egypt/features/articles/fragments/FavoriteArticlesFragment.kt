package com.evgenii.goncharov.ancient.egypt.features.articles.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentFavoriteArticlesBinding
import com.evgenii.goncharov.ancient.egypt.features.articles.view.models.FavoriteArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * №4.2
 * Doc: https://docs.google.com/document/d/1WPIP7WjD0zpfLLz-d8ZXiHINRX5n5SYOkpx7U3vp3M0/edit
 * */
@AndroidEntryPoint
class FavoriteArticlesFragment : Fragment(R.layout.fragment_favorite_articles) {

    private val viewModel: FavoriteArticlesViewModel by viewModels()
    private val binding: FragmentFavoriteArticlesBinding by viewBinding(FragmentFavoriteArticlesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentFavoriteArticlesBinding.initUi() {
        title.text = "${binding.title.text}  ${toString()}"
        btnNext1.setOnClickListener {
            viewModel.goToTheSelectedCategory()
        }
        btnNext2.setOnClickListener {
            viewModel.goToTheSelectedArticle()
        }
    }

    companion object {
        fun newInstance() = FavoriteArticlesFragment()
    }
}