package com.evgenii.goncharov.ancient.egypt.ui_kit.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.evgenii.goncharov.ancient.egypt.ui_kit.R
import com.evgenii.goncharov.ancient.egypt.ui_kit.databinding.ViewBannerBinding

class BannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var title: String? = null
    var bannerUri: String? = null
    var description: String? = null
    private val binding: ViewBannerBinding by viewBinding {
        ViewBannerBinding.bind(this)
    }

    init {
        inflate(context, R.layout.view_banner, this)
    }

    fun initView() {
        with(binding) {
            title?.let(txvTitle::setText)
            description?.let(txvDescription::setText)
            if (bannerUri.isNullOrEmpty().not()) {
                Glide.with(context)
                    .load(bannerUri)
                    .into(imvBanner)
            } else {
                throw IllegalArgumentException(ARGUMENT_EXCEPTION_MESSAGE)
            }
        }
        requestLayout()
    }

    private companion object {

        const val ARGUMENT_EXCEPTION_MESSAGE = "Banner uri image must mot empty"
    }
}