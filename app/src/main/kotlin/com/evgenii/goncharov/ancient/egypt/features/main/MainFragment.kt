package com.evgenii.goncharov.ancient.egypt.features.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentMainBinding
import com.evgenii.goncharov.ancient.egypt.features.articles.navigation.ArticlesScreens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Named

/** №2.2 */
class MainFragment : Fragment(R.layout.fragment_main) {

    @Inject @Named("BottomMenu") lateinit var router: Router
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentMainBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
        btnNext2.setOnClickListener {
            router.navigateTo(ArticlesScreens.startSelectedCategory())
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}