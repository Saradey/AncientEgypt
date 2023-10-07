package com.evgenii.goncharov.ancient.egypt.ui_kit.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.ui_kit.R
import com.evgenii.goncharov.ancient.egypt.ui_kit.databinding.BannerViewBinding

class BannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var title: String? = null
    var bannerUri: String? = null
    var description: String? = null
    private val binding: BannerViewBinding by viewBinding {
        BannerViewBinding.bind(this)
    }

    init {
        inflate(context, R.layout.banner_view, this)
    }

    fun initView() {
        with(binding) {
            title?.let(txvTitle::setText)
            description?.let(txvDescription::setText)
        }
        requestLayout()
    }
}