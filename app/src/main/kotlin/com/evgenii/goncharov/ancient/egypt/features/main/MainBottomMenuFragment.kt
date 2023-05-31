package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.BottomMenuGraphDirections
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBottomMenuBinding

/** №2.1 */
class MainBottomMenuFragment : Fragment(R.layout.fragment_main_bottom_menu) {

    private val vb: FragmentMainBottomMenuBinding by viewBinding(FragmentMainBottomMenuBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vb.initUi()
        initOnBackPressed()
    }

    private fun FragmentMainBottomMenuBinding.initUi() {
        bnvMenu.setOnItemSelectedListener(::clickItemBottomMenu)
        bnvMenu.setupWithNavController()
        toolbar.setNavigationOnClickListener(::navigationClickListener)
    }

    private fun clickItemBottomMenu(item: MenuItem): Boolean {
        val navController = vb.fcvNestedBottomMenu.getFragment<NavHostFragment>().navController
        when (item.itemId) {
            R.id.main_graph -> {
                navController.navigate(BottomMenuGraphDirections.globalActionToMain())
            }
            R.id.all_graph -> {
                navController.navigate(BottomMenuGraphDirections.globalActionToAll())
            }
            R.id.favourite_graph -> {
                navController.navigate(BottomMenuGraphDirections.globalActionToFavourite())
            }
            R.id.settings_graph -> {
                navController.navigate(BottomMenuGraphDirections.globalActionToSettings())
            }
        }
        return true
    }

    private fun navigationClickListener(view: View) {
        val navController = vb.fcvNestedBottomMenu.getFragment<NavHostFragment>().navController
        navController.navigate(BottomMenuGraphDirections.globalActionToSearch())
    }

    private fun initOnBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val navController = vb.fcvNestedBottomMenu.getFragment<NavHostFragment>().navController
                    navController.currentDestination?.id?.let { id ->
                        if(!navController.popBackStack()) {
                            requireActivity().finish()
                        }
                    }
                }
            }
        )
    }
}