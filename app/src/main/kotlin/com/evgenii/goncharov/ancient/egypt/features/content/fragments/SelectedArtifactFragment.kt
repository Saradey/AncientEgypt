package com.evgenii.goncharov.ancient.egypt.features.content.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSelectedArtifactBinding

/**
 * № 8.1
 * Doc: https://docs.google.com/document/d/1iyv35Iw84vkFnAeFNEgGS1w-tyw09L6CQMeyear_4bk/edit
 */
class SelectedArtifactFragment : Fragment(R.layout.fragment_selected_artifact) {

    private val binding: FragmentSelectedArtifactBinding by viewBinding(FragmentSelectedArtifactBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentSelectedArtifactBinding.initUi() {
    }

    companion object {
        fun newInstance() = SelectedArtifactFragment()
    }
}