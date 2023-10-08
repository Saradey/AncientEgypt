package com.evgenii.goncharov.ancient.egypt.features.main.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBinding
import com.evgenii.goncharov.ancient.egypt.databinding.LayoutErrorStateBinding
import com.evgenii.goncharov.ancient.egypt.databinding.LayoutTitleInfoBinding
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
    private val rootBinding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val errorStateBinding: LayoutErrorStateBinding by viewBinding(LayoutErrorStateBinding::bind)
    private val titleInfo: LayoutTitleInfoBinding by viewBinding(LayoutTitleInfoBinding::bind)
    private val adapter: MainContentAdapter = MainContentAdapter(::goToAllObjectOnTheMap)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.showSystemUi(requireActivity().window)
        savedInstanceState ?: viewModel.loadContent()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rootBinding.initUi()
        initObserveLiveData()
    }

    private fun initObserveLiveData() {
        viewModel.mainContentLiveData.observe(viewLifecycleOwner, ::initContentUiState)
    }

    private fun initContentUiState(contentUiState: MainContentUiState) {
        when (contentUiState) {
            MainContentUiState.Loading -> rootBinding.loading()
            is MainContentUiState.LoadingUpdateAndContentFromDb -> rootBinding.showStatusUpdate(contentUiState.content)
            is MainContentUiState.Content -> rootBinding.setContent(contentUiState.content)
            is MainContentUiState.Error -> error(contentUiState.messageError)
            is MainContentUiState.ErrorUpdate -> {}
        }
    }

    private fun FragmentMainBinding.showStatusUpdate(content: List<BaseContentModel>) {
        errorState.root.isGone = true
        loadProgress.root.isGone = true
        rcvContent.isVisible = true
        adapter.items = content
        titleInfo.root.isVisible = true
        titleInfo.root.setText(R.string.main_title_info)
        titleInfo.root.setTextColor(Color.YELLOW)
    }

    private fun FragmentMainBinding.setContent(content: List<BaseContentModel>) {
        rootBinding.titleInfo.root.isGone = true
        errorState.root.isGone = true
        loadProgress.root.isGone = true
        rcvContent.isVisible = true
        adapter.items = content
    }

    private fun FragmentMainBinding.loading() {
        rootBinding.titleInfo.root.isGone = true
        errorState.root.isGone = true
        rcvContent.isGone = true
        loadProgress.root.isVisible = true
    }

    private fun error(messageError: String?) {
        rootBinding.titleInfo.root.isGone = true
        rootBinding.rcvContent.isGone = true
        rootBinding.loadProgress.root.isGone = true
        rootBinding.errorState.root.isVisible = true
        if (messageError.isNullOrEmpty().not()) {
            errorStateBinding.txvTitleError.text = messageError
        }
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