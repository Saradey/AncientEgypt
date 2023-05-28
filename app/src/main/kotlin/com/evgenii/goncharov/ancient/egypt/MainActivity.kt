package com.evgenii.goncharov.ancient.egypt

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setStartMainGraph()
    }

    //TODO this function replace start graph, if want show onboarding do nothing, if want show bottomMenu: replace graph
    private fun setStartMainGraph() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.fcv_root_container)?.findNavController()
        if (false && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            navController?.setGraph(R.navigation.main_graph)
        }
    }
}