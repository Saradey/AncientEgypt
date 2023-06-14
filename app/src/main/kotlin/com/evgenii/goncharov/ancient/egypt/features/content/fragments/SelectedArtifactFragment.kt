package com.evgenii.goncharov.ancient.egypt.features.content.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSelectedArtifactBinding
import com.evgenii.goncharov.ancient.egypt.features.content.view.models.SelectedArtifactViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * № 8.1
 * Doc: https://docs.google.com/document/d/1iyv35Iw84vkFnAeFNEgGS1w-tyw09L6CQMeyear_4bk/edit
 */
@AndroidEntryPoint
class SelectedArtifactFragment : Fragment(R.layout.fragment_selected_artifact) {

    private val viewModel: SelectedArtifactViewModel by viewModels()
    private val binding: FragmentSelectedArtifactBinding by viewBinding(FragmentSelectedArtifactBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentSelectedArtifactBinding.initUi() {
        binding.title.text = "${binding.title.text} ${toString()}"
        btnNext1.setOnClickListener {
            viewModel.goToTheSelectedArticle()
        }
        btnNext2.setOnClickListener {
            viewModel.goToTheSelectedPhoto()
        }
        btnNext3.setOnClickListener {
            viewModel.goToTheSelectedCategory()
        }
        btnNext4.setOnClickListener {
            viewModel.goToTheMapSelectedArtifact()
        }
    }

    companion object {
        fun newInstance() = SelectedArtifactFragment()
    }
}