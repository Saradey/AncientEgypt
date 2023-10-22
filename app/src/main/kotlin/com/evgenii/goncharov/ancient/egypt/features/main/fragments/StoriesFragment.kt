package com.evgenii.goncharov.ancient.egypt.features.main.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.base.models.state.UiState
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentStoriesBinding
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.view.models.StoriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * №2.3
 * Doc: https://docs.google.com/document/d/1ovoKNU7U52e7Xph28jqAQGzrN6XWRoWQxJZ7PLut1pE/edit
 * */
@AndroidEntryPoint
class StoriesFragment : Fragment(R.layout.fragment_stories) {

    private val viewModel: StoriesViewModel by viewModels()
    private val binding: FragmentStoriesBinding by viewBinding(FragmentStoriesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        savedInstanceState ?: initStories()
        binding.initUi()
        observeState()
    }

    private fun initStories() {
        viewModel.initModel(getArgSelectedStories())
        viewModel.initStoriesState()
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.storiesState.collectLatest(::setStoriesState)
        }
    }

    private fun FragmentStoriesBinding.initUi() {

    }

    private fun setStoriesState(storiesState: UiState<StoriesModel>) {

    }

    private fun getArgSelectedStories(): SelectedStoriesModel {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(SELECTED_STORIES_KEY, SelectedStoriesModel::class.java)
        } else {
            arguments?.getParcelable(SELECTED_STORIES_KEY)
        } ?: throw IllegalArgumentException(ERROR_MESSAGE_MODEL_MUST_NOT_EMPTY)
    }

    companion object {
        private const val SELECTED_STORIES_KEY = "SELECTED_STORIES_KEY"
        private const val ERROR_MESSAGE_MODEL_MUST_NOT_EMPTY = "Selected stories must not null"

        fun newInstance(model: SelectedStoriesModel) = StoriesFragment().apply {
            val bundleArg = Bundle()
            bundleArg.putParcelable(SELECTED_STORIES_KEY, model)
            arguments = bundleArg
        }
    }
}