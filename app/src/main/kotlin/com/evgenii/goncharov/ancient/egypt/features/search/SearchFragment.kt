package com.evgenii.goncharov.ancient.egypt.features.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSearchBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SetVisibilityToBottomMenuToolbarListener
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/** №3 */
@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    @Inject @Named(NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION) lateinit var router: Router
    @Inject @Named(NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION) lateinit var navigatorHolder: NavigatorHolder
    private val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (parentFragment as? SetVisibilityToBottomMenuToolbarListener)?.setVisibilityToolbar(false)
        binding.initUi()
    }

    private fun FragmentSearchBinding.initUi() {
        btnNext1.setOnClickListener {

        }
        btnNext2.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (parentFragment as? SetVisibilityToBottomMenuToolbarListener)?.setVisibilityToolbar(true)
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}