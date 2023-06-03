package com.evgenii.goncharov.ancient.egypt.features.articles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSelectedCategoryBinding

/** №4.3 */
class SelectedCategoryFragment : Fragment(R.layout.fragment_selected_category) {

    private val binding: FragmentSelectedCategoryBinding by viewBinding(
        FragmentSelectedCategoryBinding::bind
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentSelectedCategoryBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
    }

    companion object {
        fun newInstance() = SelectedCategoryFragment()
    }
}