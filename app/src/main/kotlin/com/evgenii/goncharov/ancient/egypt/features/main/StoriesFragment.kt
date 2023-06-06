package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentStoriesBinding

/** №2.3 */
class StoriesFragment : Fragment(R.layout.fragment_stories) {

    private val binding: FragmentStoriesBinding by viewBinding(FragmentStoriesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentStoriesBinding.initUi() {}

    companion object {
        fun newInstance() = StoriesFragment()
    }
}