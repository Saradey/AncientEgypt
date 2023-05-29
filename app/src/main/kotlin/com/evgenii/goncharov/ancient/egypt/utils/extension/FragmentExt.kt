package com.evgenii.goncharov.ancient.egypt.utils.extension

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.evgenii.goncharov.ancient.egypt.R

fun Fragment.findRootNavController(): NavController =
    requireActivity().findNavController(R.id.fcv_root_container)