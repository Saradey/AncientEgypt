package com.evgenii.goncharov.ancient.egypt.features.content.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.FragmentSelectedPhotoBinding
import com.evgenii.goncharov.ancient.egypt.features.content.view.models.SelectedPhotoViewModel

/**
 * №6.2
 * Doc: https://docs.google.com/document/d/1IYyqvu-MiVcGMDe2-UPr3zOc95rCl09uqpWlFHYaVRo/edit
 * */
class SelectedPhotoFragment : Fragment(R.layout.fragment_selected_photo) {

    private val viewModel: SelectedPhotoViewModel by viewModels()
    private val binding: FragmentSelectedPhotoBinding by viewBinding(FragmentSelectedPhotoBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentSelectedPhotoBinding.initUi() {
        title.text = "${binding.title.text} ${toString()}"
    }

    companion object {

        fun newInstance() = SelectedPhotoFragment()
    }
}