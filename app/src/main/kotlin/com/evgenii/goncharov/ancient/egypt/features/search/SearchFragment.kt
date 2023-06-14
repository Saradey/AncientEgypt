package com.evgenii.goncharov.ancient.egypt.features.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * №3
 * Doc: https://docs.google.com/document/d/1ts5R-XO3gCcr-_6CGfXUvGNQX6AKPv_WBIPwvN2U4YU/edit
 * */
@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by viewModels()
    private val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentSearchBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
        btnNext1.setOnClickListener {
            viewModel.goToTheSelectedCategory()
        }
        btnNext2.setOnClickListener {
            viewModel.goToTheSelectedArticle()
        }
        btnNext3.setOnClickListener {
            viewModel.goToTheSelectedArtifact()
        }
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}