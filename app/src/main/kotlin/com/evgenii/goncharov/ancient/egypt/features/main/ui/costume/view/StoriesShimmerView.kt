package com.evgenii.goncharov.ancient.egypt.features.main.ui.costume.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.evgenii.goncharov.ancient.egypt.R

class StoriesShimmerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_stories_shimmer, this)
    }
}