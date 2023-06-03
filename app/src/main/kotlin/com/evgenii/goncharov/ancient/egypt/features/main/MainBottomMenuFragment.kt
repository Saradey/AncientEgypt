package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBottomMenuBinding
import com.evgenii.goncharov.ancient.egypt.features.main.navigation.MainBottomNavigator
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/** №2.1 */
@AndroidEntryPoint
class MainBottomMenuFragment : Fragment(R.layout.fragment_main_bottom_menu) {

    @Inject @Named("BottomMenu") lateinit var router: Router
    private val binding: FragmentMainBottomMenuBinding by viewBinding(FragmentMainBottomMenuBinding::bind)
    private val navigator: MainBottomNavigator by lazy {
        MainBottomNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentMainBottomMenuBinding.initUi() {
        binding.bnvMenu.setOnItemSelectedListener(::itemBottomMenuClickListener)
    }

    private fun itemBottomMenuClickListener(item: MenuItem): Boolean {
        when(item.itemId) {

        }
        return true
    }

    companion object {
        fun newInstance() = MainBottomMenuFragment()
    }
}