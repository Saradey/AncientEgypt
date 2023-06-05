package com.evgenii.goncharov.ancient.egypt.features.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSearchBinding
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SetVisibilityToBottomMenuToolbarListener

/** №3 */
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (parentFragment as? SetVisibilityToBottomMenuToolbarListener)?.setVisibilityToolbar(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (parentFragment as? SetVisibilityToBottomMenuToolbarListener)?.setVisibilityToolbar(true)
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}