package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBottomMenuBinding
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainScreens
import com.evgenii.goncharov.ancient.egypt.features.settings.navigation.SettingsScreens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/** №2.1 */
@AndroidEntryPoint
class MainBottomMenuFragment : Fragment(R.layout.fragment_main_bottom_menu) {

    @Inject @Named("BottomMenu") lateinit var router: Router
    @Inject @Named("BottomMenu") lateinit var navigatorHolder: NavigatorHolder
    private val binding: FragmentMainBottomMenuBinding by viewBinding(FragmentMainBottomMenuBinding::bind)
    private val navigator: MainBottomNavigator by lazy {
        MainBottomNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
        savedInstanceState ?: router.navigateTo(MainScreens.startMain())
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    fun selectTabBottomMenu(selectedBackstackMenu: String) {
        binding.bnvMenu.setOnItemSelectedListener(null)
        when (selectedBackstackMenu) {

        }
        binding.bnvMenu.setOnItemSelectedListener(::itemBottomMenuClickListener)
    }

    private fun FragmentMainBottomMenuBinding.initUi() {
        binding.bnvMenu.setOnItemSelectedListener(::itemBottomMenuClickListener)
        binding.toolbar.setNavigationOnClickListener(::toolbarNavigationOnClickListener)
    }

    private fun itemBottomMenuClickListener(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main -> router.navigateTo(MainScreens.startMain())
            R.id.all -> router.navigateTo(ArticlesScreens.startAllArticles())
            R.id.favourite -> router.navigateTo(ArticlesScreens.startFavoriteArticles())
            R.id.settings -> router.navigateTo(SettingsScreens.startSettings())
        }
        return true
    }

    private fun toolbarNavigationOnClickListener(view: View) {}

    companion object {
        fun newInstance() = MainBottomMenuFragment()
    }
}