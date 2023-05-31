package com.evgenii.goncharov.ancient.egypt.features.articles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentAllArticlesBinding

/** №4.1 */
class AllArticlesFragment : Fragment(R.layout.fragment_all_articles) {

    private val binding: FragmentAllArticlesBinding by viewBinding(FragmentAllArticlesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.title.text = "${binding.title.text} ${toString()}"
    }
}