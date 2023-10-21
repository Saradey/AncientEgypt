package com.evgenii.goncharov.ancient.egypt.features.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentStoriesBinding
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.view.models.StoriesViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * №2.3
 * Doc: https://docs.google.com/document/d/1ovoKNU7U52e7Xph28jqAQGzrN6XWRoWQxJZ7PLut1pE/edit
 * */
@AndroidEntryPoint
class StoriesFragment : Fragment(R.layout.fragment_stories) {

    private val viewModel: StoriesViewModel by viewModels()
    private val binding: FragmentStoriesBinding by viewBinding(FragmentStoriesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentStoriesBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
        btnNext1.setOnClickListener {
            viewModel.goToTheeSelectedArticle()
        }
        btnNext2.setOnClickListener {
            viewModel.goToTheSelectedCategory()
        }
        btnNext3.setOnClickListener {
            viewModel.goToTheMapAndArticle()
        }
        btnNext4.setOnClickListener {
            viewModel.goToTheSelectedArtifact()
        }
    }

    companion object {
        private const val SELECTED_STORIES_KEY = "SELECTED_STORIES_KEY"

        fun newInstance(model: SelectedStoriesModel) = StoriesFragment().apply {
            val bundleArg = Bundle()
            bundleArg.putParcelable(SELECTED_STORIES_KEY, model)
            arguments = bundleArg
        }
    }
}