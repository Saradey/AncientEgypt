package com.evgenii.goncharov.ancient.egypt.ui_kit.view

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.annotation.Px
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.evgenii.goncharov.ancient.egypt.ui_kit.R
import com.evgenii.goncharov.ancient.egypt.ui_kit.annotations.Dp
import com.evgenii.goncharov.ancient.egypt.ui_kit.extensions.dpToPx

class TextButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatTextView(context, attrs, defStyleAttr) {

    @Px
    private val padding4dp = context.dpToPx(PADDING_4DP)

    init {
        setTextAppearance(R.style.Text_MainTextColor_CormorantSemibold_18)
        clipToOutline = true
        setBackgroundResource(R.drawable.background_text_rectangle_round)
        setPadding(padding4dp, padding4dp, padding4dp, padding4dp)
        val typedForeground = TypedValue()
        context.theme.resolveAttribute(
            android.R.attr.selectableItemBackground, typedForeground, true
        )
        foreground = ContextCompat.getDrawable(context, typedForeground.resourceId)
        gravity = Gravity.CENTER
    }

    companion object {

        @Dp
        private const val PADDING_4DP = 4
    }
}