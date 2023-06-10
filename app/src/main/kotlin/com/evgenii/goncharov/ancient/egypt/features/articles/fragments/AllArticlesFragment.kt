package com.evgenii.goncharov.ancient.egypt.features.articles.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentAllArticlesBinding
import com.evgenii.goncharov.ancient.egypt.features.articles.view.models.AllArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * №4.1
 * Doc: https://docs.google.com/document/d/1Unhsl5LGMDSO3OI14Kn6QGI5V-Hj2_fW-Mpgu__WVK8/edit
 * */
@AndroidEntryPoint
class AllArticlesFragment : Fragment(R.layout.fragment_all_articles) {

    private val viewModel: AllArticlesViewModel by viewModels()
    private val binding: FragmentAllArticlesBinding by viewBinding(FragmentAllArticlesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentAllArticlesBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
        btnNext1.setOnClickListener {
            viewModel.goToTheSelectedCategory()
        }
        btnNext2.setOnClickListener {
            viewModel.goToTheSelectedArticle()
        }
    }

    companion object {
        fun newInstance() = AllArticlesFragment()
    }
}