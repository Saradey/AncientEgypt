package com.evgenii.goncharov.ancient.egypt.ui_kit.extensions

import android.content.Context
import android.util.TypedValue

fun Context.dpToPx(dp: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
        resources.displayMetrics
    ).toInt()
}