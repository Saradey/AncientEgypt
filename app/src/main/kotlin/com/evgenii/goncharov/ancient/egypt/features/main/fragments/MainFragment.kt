package com.evgenii.goncharov.ancient.egypt.features.main.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBinding
import com.evgenii.goncharov.ancient.egypt.databinding.LayoutErrorStateBinding
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BaseContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedBanner
import com.evgenii.goncharov.ancient.egypt.features.main.models.state.MainContentUiState
import com.evgenii.goncharov.ancient.egypt.features.main.ui.MainContentAdapter
import com.evgenii.goncharov.ancient.egypt.features.main.view.models.MainViewModel
import com.evgenii.goncharov.ancient.egypt.utils.StatusBarUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * №2.2
 * Doc: https://docs.google.com/document/d/1R1-U1C_VLGf1kwnR2W7SJf_i0znYaJqmfNhZv0G8T5E/edit
 * */
@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()
    private val rootBinding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val errorStateBinding: LayoutErrorStateBinding by viewBinding {
        LayoutErrorStateBinding.bind(rootBinding.errorState.root)
    }
    private val adapter: MainContentAdapter = MainContentAdapter(
        ::goToAllObjectOnTheMap,
        ::bannerClick
    )

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
            is MainContentUiState.Update -> rootBinding.showStatusUpdate()
            is MainContentUiState.LoadingUpdateAndContentFromDb -> rootBinding.showStatusUpdate(contentUiState.content)
            is MainContentUiState.Content -> rootBinding.setContent(contentUiState.content)
            is MainContentUiState.Error -> rootBinding.error(contentUiState.messageError)
            is MainContentUiState.ErrorUpdate -> rootBinding.errorUpdate()
        }
    }

    private fun FragmentMainBinding.errorUpdate() {
        rflUpdateContent.isRefreshing = false
        titleInfo.root.isVisible = true
        titleInfo.root.setText(R.string.main_title_info_error)
        titleInfo.root.setTextColor(Color.RED)
        lifecycleScope.launch {
            delay(HIDE_ERROR_DELAY)
            titleInfo.root.isGone = true
        }
    }

    private fun FragmentMainBinding.showStatusUpdate(content: List<BaseContentModel>) {
        showStatusUpdate()
        adapter.items = content
        rflUpdateContent.isRefreshing = false
    }

    private fun FragmentMainBinding.showStatusUpdate() {
        errorState.root.isGone = true
        loadProgress.root.isGone = true
        rcvContent.isVisible = true
        titleInfo.root.isVisible = true
        titleInfo.root.setText(R.string.main_title_info)
        titleInfo.root.setTextColor(Color.YELLOW)
    }

    private fun FragmentMainBinding.setContent(content: List<BaseContentModel>) {
        rflUpdateContent.isRefreshing = false
        rootBinding.titleInfo.root.isGone = true
        errorState.root.isGone = true
        loadProgress.root.isGone = true
        rcvContent.isVisible = true
        adapter.items = content
        adapter.notifyDataSetChanged()
    }

    private fun FragmentMainBinding.loading() {
        rflUpdateContent.isRefreshing = false
        rootBinding.titleInfo.root.isGone = true
        errorState.root.isGone = true
        rcvContent.isGone = true
        loadProgress.root.isVisible = true
    }

    private fun FragmentMainBinding.error(messageError: String?) {
        rflUpdateContent.isRefreshing = false
        titleInfo.root.isGone = true
        rcvContent.isGone = true
        loadProgress.root.isGone = true
        errorState.root.isVisible = true
        if (messageError.isNullOrEmpty().not()) {
            errorStateBinding.txvTitleError.text = messageError
        }
    }

    private fun FragmentMainBinding.initUi() {
        rcvContent.adapter = adapter
        rflUpdateContent.setOnRefreshListener(viewModel::refreshToUpdate)
        toolbar.setNavigationOnClickListener {
            viewModel.goToTheSearchScreen()
        }
    }

    private fun goToAllObjectOnTheMap() {
        viewModel.goToTheMapAllObjects()
    }

    private fun bannerClick(model: SelectedBanner) {
        viewModel.bannerClick(model)
    }

    companion object {
        private const val HIDE_ERROR_DELAY = 1000L

        fun newInstance() = MainFragment()
    }
}