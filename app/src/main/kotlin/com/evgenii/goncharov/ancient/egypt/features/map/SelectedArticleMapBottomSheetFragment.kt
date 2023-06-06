package com.evgenii.goncharov.ancient.egypt.features.map

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.R
import com.evgenii.goncharov.ancient.egypt.databinding.BottomSheetSelectedArticleBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/** №7.2 */
class SelectedArticleMapBottomSheetFragment : BottomSheetDialogFragment(
    R.layout.bottom_sheet_selected_article
) {

    private val binding: BottomSheetSelectedArticleBinding by viewBinding(BottomSheetSelectedArticleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun BottomSheetSelectedArticleBinding.initUi() {

    }
}