package com.evgenii.goncharov.ancient.egypt.features.content.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSelectedArticleBinding
import com.evgenii.goncharov.ancient.egypt.features.content.view.models.SelectedArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * №6.1
 * Doc: https://docs.google.com/document/d/1lPaglQbODCqhaGQ3-UAeGdSE8ltozrNwYwVriCH1Joc/edit
 * */
@AndroidEntryPoint
class SelectedArticleFragment : Fragment(R.layout.fragment_selected_article) {

    private val viewModel: SelectedArticleViewModel by viewModels()
    private val binding: FragmentSelectedArticleBinding by viewBinding(FragmentSelectedArticleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.title.text = "${binding.title.text} ${toString()}"
        binding.initUi()
    }

    private fun FragmentSelectedArticleBinding.initUi() {
        btnNext1.setOnClickListener {
            viewModel.goToTheSelectedArticle()
        }
        btnNext2.setOnClickListener {
            viewModel.goToTheAncientEgyptMapAndArticle()
        }
        btnNext3.setOnClickListener {
            viewModel.goToTheSelectedCategory()
        }
        btnNext4.setOnClickListener {
            viewModel.goToTheSelectedPhoto()
        }
    }

    companion object {
        fun newInstance() = SelectedArticleFragment()
    }
}