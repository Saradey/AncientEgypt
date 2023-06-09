package com.evgenii.goncharov.ancient.egypt.features.content.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.features.content.view.models.SelectedPhotoViewModel

/**
 * №6.2
 * Doc: https://docs.google.com/document/d/1IYyqvu-MiVcGMDe2-UPr3zOc95rCl09uqpWlFHYaVRo/edit
 * */
class SelectedPhotoFragment : Fragment(R.layout.fragment_selected_photo) {

    private val viewModel: SelectedPhotoViewModel by viewModels()

    companion object {

        fun newInstance() = SelectedPhotoFragment()
    }
}