package com.evgenii.goncharov.ancient.egypt.ui_kit.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.evgenii.goncharov.ancient.egypt.ui_kit.R

class BannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val title: String? = null
    val bannerUri: String? = null
    val description: String? = null

    init {
        inflate(context, R.layout.banner_view, this)
    }
}