package com.evgenii.goncharov.ancient.egypt.ui_kit.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Px
import androidx.core.content.ContextCompat
import com.evgenii.goncharov.ancient.egypt.ui_kit.R
import com.evgenii.goncharov.ancient.egypt.ui_kit.annotations.Dp
import com.evgenii.goncharov.ancient.egypt.ui_kit.extensions.dpToPx

class DotIndicatorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    var nextPage = 1
        set(value) {
            field = value
            invalidate()
        }

    @Px
    private val height20dp = context.dpToPx(HEIGHT_20DP)

    @Px
    private val radiusDot4dp = context.dpToPx(RADIUS_4DP).toFloat()

    @Px
    private val widthPixel = context.dpToPx(
        (RADIUS_4DP * 5) * DOTS_SIZE
    )

    private val paintActivatedDot = Paint().apply {
        isAntiAlias = true
        color = Color.WHITE
    }

    private val paintDot = Paint().apply {
        isAntiAlias = true
        color = ContextCompat.getColor(context, R.color.white_alpha)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(widthPixel, height20dp)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (dot in 1..DOTS_SIZE) {
            if (nextPage == dot) {
                canvas.drawCircle(
                    dot * (radiusDot4dp * DOTS_OFFSET),
                    height20dp / HALF_HEIGHT,
                    radiusDot4dp,
                    paintActivatedDot
                )
            } else {
                canvas.drawCircle(
                    dot * (radiusDot4dp * DOTS_OFFSET),
                    height20dp / HALF_HEIGHT,
                    radiusDot4dp,
                    paintDot
                )
            }
        }
    }

    companion object {
        private const val HALF_HEIGHT = 2f
        private const val DOTS_SIZE = 3
        private const val DOTS_OFFSET = 4

        @Dp
        private const val HEIGHT_20DP = 20

        @Dp
        private const val RADIUS_4DP = 4
    }
}