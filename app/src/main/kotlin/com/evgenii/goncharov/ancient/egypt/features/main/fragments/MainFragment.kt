package com.evgenii.goncharov.ancient.egypt.features.main.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBinding
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BaseContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.state.MainContentUiState
import com.evgenii.goncharov.ancient.egypt.features.main.ui.MainContentAdapter
import com.evgenii.goncharov.ancient.egypt.features.main.view.models.MainViewModel
import com.evgenii.goncharov.ancient.egypt.utils.StatusBarUtils
import dagger.hilt.android.AndroidEntryPoint

/**
 * №2.2
 * Doc: https://docs.google.com/document/d/1R1-U1C_VLGf1kwnR2W7SJf_i0znYaJqmfNhZv0G8T5E/edit
 * */
@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val adapter: MainContentAdapter = MainContentAdapter(
        ::goToAllObjectOnTheMap
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.showSystemUi(requireActivity().window)
        savedInstanceState ?: viewModel.loadContentFromNetwork()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
        initObserveLiveData()
    }

    private fun initObserveLiveData() {
        viewModel.mainContentLiveData.observe(viewLifecycleOwner, ::initContentUiState)
    }

    private fun initContentUiState(contentUiState: MainContentUiState) {
        when (contentUiState) {
            MainContentUiState.Loading -> binding.loading()
            MainContentUiState.LoadingUpdate -> {}
            is MainContentUiState.Content -> binding.setContent(contentUiState.content)
            is MainContentUiState.Error -> {}
            is MainContentUiState.ErrorUpdate -> {}
        }
    }

    private fun FragmentMainBinding.setContent(content: List<BaseContentModel>) {
        loadProgress.root.isGone = true
        rcvContent.isVisible = true
        adapter.items = content
    }

    private fun FragmentMainBinding.loading() {
        rcvContent.isGone = true
        loadProgress.root.isVisible = true
    }

    private fun FragmentMainBinding.initUi() {
        rcvContent.adapter = adapter
    }

    private fun goToAllObjectOnTheMap() {
        viewModel.goToTheMapAllObjects()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}