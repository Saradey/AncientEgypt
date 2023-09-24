package com.evgenii.goncharov.ancient.egypt.utils

import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import android.window.SplashScreenView
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.evgenii.goncharov.ancient.egypt.MainActivity
import com.evgenii.goncharov.ancient.egypt.R

object SplashHelper {

    fun MainActivity.configSplashScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setOnExitAnimationListener { onExitAnimationListener ->
                val splashDrawable = AppCompatResources.getDrawable(
                    applicationContext,
                    R.drawable.animated_ic_splash
                )
                (onExitAnimationListener.iconView as AppCompatImageView).setImageDrawable(
                    splashDrawable
                )
                val splashRootView = (onExitAnimationListener.view as SplashScreenView)
                val mainBackground = ImageView(applicationContext).apply {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    setImageResource(R.drawable.main_background_and_gradient)
                    translationZ = MAIN_BACKGROUND_TRANSLATION_Z
                }
                splashRootView.addView(mainBackground)
                (splashDrawable as AnimatedVectorDrawable).start()
                splashDrawable.registerAnimationCallback(
                    object : Animatable2.AnimationCallback() {
                        override fun onAnimationEnd(drawable: Drawable?) {
                            onExitAnimationListener.remove()
                        }
                    }
                )
            }
        }
    }

    private const val MAIN_BACKGROUND_TRANSLATION_Z = -1f
}