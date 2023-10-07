package com.evgenii.goncharov.ancient.egypt.features.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBinding
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.showSystemUi(requireActivity().window)
        viewModel.loadContentFromNetwork()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentMainBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
        btnNext1.setOnClickListener {
            viewModel.goToTheStories()
        }
        btnNext2.setOnClickListener {
            viewModel.goToTheSelectedCategory()
        }
        btnNext3.setOnClickListener {
            viewModel.goToTheSelectedArticle()
        }
        btnNext4.setOnClickListener {
            viewModel.goToTheMapAllObjects()
        }
        btnNext5.setOnClickListener {
            viewModel.goToTheMapSelectedArticle()
        }
        btnNext6.setOnClickListener {
            viewModel.goToTheSelectedArtifact()
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}