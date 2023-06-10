package com.evgenii.goncharov.ancient.egypt.features.main.fragments

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBottomMenuBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SelectTabBottomMenuListener
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SetVisibilityToBottomMenuToolbarListener
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_ALL
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_FAVORITE
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_MAIN
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_SETTINGS
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.OnBackPressedBottomMenuManager
import com.evgenii.goncharov.ancient.egypt.features.main.view.models.MainBottomMenuViewModel
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/**
 * №2.1
 * Doc: https://docs.google.com/document/d/1OHlfzwDKKe0fmORtHqtLLVOBbz0xfnIC49F3zmDr2_c/edit
 * */
@AndroidEntryPoint
class MainBottomMenuFragment : Fragment(R.layout.fragment_main_bottom_menu),
    SelectTabBottomMenuListener,
    SetVisibilityToBottomMenuToolbarListener {

    private val viewModel: MainBottomMenuViewModel by viewModels()
    @Inject @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var onBackPressed: OnBackPressedBottomMenuManager
    @Inject lateinit var factoryBottomNavigator: MainBottomNavigator.Factory
    private val binding: FragmentMainBottomMenuBinding by viewBinding(FragmentMainBottomMenuBinding::bind)
    private val navigator: MainBottomNavigator by lazy {
        factoryBottomNavigator.create(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: viewModel.goToTheMain()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressed)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
        navigator.checkToolbarStatus()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun selectTabBottomMenu(selectedBackstackMenu: String) {
        with(binding) {
            bnvMenu.setOnItemSelectedListener(null)
            when (selectedBackstackMenu) {
                BACKSTACK_NAME_MAIN -> bnvMenu.selectedItemId = R.id.main
                BACKSTACK_NAME_ALL -> bnvMenu.selectedItemId = R.id.all
                BACKSTACK_NAME_FAVORITE -> bnvMenu.selectedItemId = R.id.favourite
                BACKSTACK_NAME_SETTINGS -> bnvMenu.selectedItemId = R.id.settings
            }
            bnvMenu.setOnItemSelectedListener(::itemBottomMenuClickListener)
        }
    }

    override fun setVisibilityToolbar(isVisible: Boolean) {
        binding.toolbar.isVisible = isVisible
    }

    private fun FragmentMainBottomMenuBinding.initUi() {
        bnvMenu.setOnItemSelectedListener(::itemBottomMenuClickListener)
        toolbar.setNavigationOnClickListener(::toolbarNavigationOnClickListener)
        toolbar.title = Integer.toHexString(System.identityHashCode(this@MainBottomMenuFragment.toString()))
    }

    private fun itemBottomMenuClickListener(item: MenuItem): Boolean {
        if (item.itemId != binding.bnvMenu.selectedItemId) {
            when (item.itemId) {
                R.id.main -> viewModel.goToTheMain()
                R.id.all -> viewModel.goToTheAllArticles()
                R.id.favourite -> viewModel.goToTheFavoriteArticles()
                R.id.settings -> viewModel.goToTheSettings()
            }
        }
        return true
    }

    private fun toolbarNavigationOnClickListener(view: View) {
        viewModel.goToTheSearch()
        binding.toolbar.isGone = true
    }

    companion object {
        fun newInstance() = MainBottomMenuFragment()
    }
}