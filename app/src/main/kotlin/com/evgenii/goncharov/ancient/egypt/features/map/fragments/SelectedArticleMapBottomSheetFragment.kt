package com.evgenii.goncharov.ancient.egypt.features.map.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.BottomSheetSelectedArticleBinding
import com.evgenii.goncharov.ancient.egypt.features.map.view.models.SelectedArticleMapViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * №7.2
 * Doc: https://docs.google.com/document/d/143lUGWeHghCzlz8Gzj9FeyFrKHh9z_rbn7I8LBia330/edit
 * */
@AndroidEntryPoint
class SelectedArticleMapBottomSheetFragment : BottomSheetDialogFragment(
    R.layout.bottom_sheet_selected_article
) {

    private val viewModel: SelectedArticleMapViewModel by viewModels()
    private val binding: BottomSheetSelectedArticleBinding by viewBinding(BottomSheetSelectedArticleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun BottomSheetSelectedArticleBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
        btnNext1.setOnClickListener {
            viewModel.goToTheSelectedCategory()
            dismiss()
        }
        btnNext2.setOnClickListener {
            viewModel.gotoTheSelectedArticle()
            dismiss()
        }
        btnNext3.setOnClickListener {
            viewModel.goToTheSelectedArtifact()
            dismiss()
        }
    }

    companion object {
        fun newInstance() = SelectedArticleMapBottomSheetFragment()
    }
}