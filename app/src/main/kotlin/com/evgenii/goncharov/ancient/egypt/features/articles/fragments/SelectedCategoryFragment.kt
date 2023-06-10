package com.evgenii.goncharov.ancient.egypt.features.articles.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSelectedCategoryBinding
import com.evgenii.goncharov.ancient.egypt.features.articles.view.models.SelectedCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * №4.3
 * Doc: https://docs.google.com/document/d/1j0E35ji6mdQOkjrloBDTpHrtasDbyBWcXV7EJQ9a3rE/edit
 * */
@AndroidEntryPoint
class SelectedCategoryFragment : Fragment(R.layout.fragment_selected_category) {

    private val viewModel: SelectedCategoryViewModel by viewModels()
    private val binding: FragmentSelectedCategoryBinding by viewBinding(FragmentSelectedCategoryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentSelectedCategoryBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
        btnNext1.setOnClickListener {
            viewModel.goToTheSelectedArticle()
        }
    }

    companion object {
        fun newInstance() = SelectedCategoryFragment()
    }
}