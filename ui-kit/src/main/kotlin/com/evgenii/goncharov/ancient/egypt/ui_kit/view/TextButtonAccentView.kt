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

class TextButtonAccentView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatTextView(context, attrs, defStyleAttr) {

    @Px
    private val padding8dp = context.dpToPx(PADDING_8DP)

    init {
        setTextAppearance(R.style.Text_AccentTextColor_CormorantSemibold_26)
        clipToOutline = true
        setPadding(padding8dp, padding8dp, padding8dp, padding8dp)
        setBackgroundResource(R.drawable.background_white_text_rectangle_round)
        gravity = Gravity.CENTER
        val typedForeground = TypedValue()
        context.theme.resolveAttribute(
            android.R.attr.selectableItemBackground,
            typedForeground,
            true
        )
        foreground = ContextCompat.getDrawable(context, typedForeground.resourceId)
    }

    companion object {
        @Dp
        private const val PADDING_8DP = 8
    }
}