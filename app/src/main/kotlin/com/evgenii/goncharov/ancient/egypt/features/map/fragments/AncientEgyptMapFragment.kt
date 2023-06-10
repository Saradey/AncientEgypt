package com.evgenii.goncharov.ancient.egypt.features.map.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.common.MultiViewModelFactory
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentAncientEgyptMapBinding
import com.evgenii.goncharov.ancient.egypt.features.map.view.models.AncientEgyptMapViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * №7.1
 * Doc: https://docs.google.com/document/d/1qxYmxOILt4kwwRenP4wSIjXQNup3CLXB9ir7XM3Hjr4/edit
 * */
@AndroidEntryPoint
class AncientEgyptMapFragment : Fragment(R.layout.fragment_ancient_egypt_map) {

    @Inject lateinit var factory: AncientEgyptMapViewModel.Factory
    private val binding: FragmentAncientEgyptMapBinding by viewBinding(FragmentAncientEgyptMapBinding::bind)
    private val viewModel: AncientEgyptMapViewModel by viewModels {
        MultiViewModelFactory {
            factory.create(
                arguments?.getBoolean(OPEN_ARTICLE_BOTTOM_SHEET_KEY, false) ?: false
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initStateMap()
        binding.initUi()
    }

    private fun initStateMap() {
        viewModel.initStateMap()
    }

    private fun FragmentAncientEgyptMapBinding.initUi() {
        btnNext1.setOnClickListener {
            viewModel.goToTheSelectedArticle()
        }
        val isOpenArticle = arguments?.getBoolean(OPEN_ARTICLE_BOTTOM_SHEET_KEY, false) ?: false
        if (isOpenArticle) {
            title.text = "${title.text} ${toString()} Single object"
        } else {
            title.text = "${binding.title.text} ${toString()}"
        }
    }

    companion object {

        fun newInstance(openArticleToBottomSheet: Boolean): Fragment {
            val fragment = AncientEgyptMapFragment()
            fragment.arguments = Bundle().apply {
                putBoolean(OPEN_ARTICLE_BOTTOM_SHEET_KEY, openArticleToBottomSheet)
            }
            return fragment
        }

        private const val OPEN_ARTICLE_BOTTOM_SHEET_KEY = "OPEN_ARTICLE_BOTTOM_SHEET_KEY"
    }
}