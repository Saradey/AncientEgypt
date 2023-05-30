package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.BottomMenuGraphDirections
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBottomMenuBinding

/** №2.1 */
class MainBottomMenuFragment : Fragment(R.layout.fragment_main_bottom_menu) {

    private val vb: FragmentMainBottomMenuBinding by viewBinding(FragmentMainBottomMenuBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vb.initUi()
    }

    private fun FragmentMainBottomMenuBinding.initUi() {
        bnvMenu.setOnItemSelectedListener(::clickItemBottomMenu)
    }

    private fun clickItemBottomMenu(item: MenuItem): Boolean {
        val navController = vb.fcvNestedBottomMenu.getFragment<NavHostFragment>().navController
        when (item.itemId) {
            R.id.main_graph -> {

            }

            R.id.all_graph -> {
                navController.navigate(BottomMenuGraphDirections.globalActionToAll())
            }

            R.id.favourite_graph -> {

            }

            R.id.settings_graph -> {

            }
        }
        return true
    }
}