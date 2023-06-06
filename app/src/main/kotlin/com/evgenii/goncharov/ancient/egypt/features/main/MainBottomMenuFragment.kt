package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBottomMenuBinding
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_ACTIVITY_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.di.NavigationModule.QUALIFIER_BOTTOM_MENU_NAVIGATION
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SelectTabBottomMenuListener
import com.evgenii.goncharov.ancient.egypt.features.main.contracts.SetVisibilityToBottomMenuToolbarListener
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_ALL
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_FAVORITE
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_MAIN
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator.Companion.BACKSTACK_NAME_SETTINGS
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.OnBackPressedBottomMenuManager
import com.evgenii.goncharov.ancient.egypt.features.search.navigation.SearchScreens
import com.evgenii.goncharov.ancient.egypt.features.settings.navigation.SettingsScreens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/** №2.1 */
@AndroidEntryPoint
class MainBottomMenuFragment : Fragment(R.layout.fragment_main_bottom_menu),
    SelectTabBottomMenuListener,
    SetVisibilityToBottomMenuToolbarListener {

    @Inject @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) lateinit var router: Router
    @Inject @Named(QUALIFIER_BOTTOM_MENU_NAVIGATION) lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var onBackPressed: OnBackPressedBottomMenuManager
    @Inject @Named(QUALIFIER_ACTIVITY_NAVIGATION) lateinit var mainActivityRouter: Router
    private val binding: FragmentMainBottomMenuBinding by viewBinding(FragmentMainBottomMenuBinding::bind)
    private val navigator: MainBottomNavigator by lazy {
        MainBottomNavigator(
            childFragmentManager,
            childFragmentManager.fragmentFactory,
            this,
            mainActivityRouter
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.navigateTo(MainScreens.startMain())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressed)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
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
    }

    private fun itemBottomMenuClickListener(item: MenuItem): Boolean {
        if (item.itemId != binding.bnvMenu.selectedItemId) {
            when (item.itemId) {
                R.id.main -> router.navigateTo(MainScreens.startMain())
                R.id.all -> router.navigateTo(ArticlesScreens.startAllArticles())
                R.id.favourite -> router.navigateTo(ArticlesScreens.startFavoriteArticles())
                R.id.settings -> router.navigateTo(SettingsScreens.startSettings())
            }
        }
        return true
    }

    private fun toolbarNavigationOnClickListener(view: View) {
        router.navigateTo(SearchScreens.startSearch())
    }

    companion object {
        fun newInstance() = MainBottomMenuFragment()
    }
}