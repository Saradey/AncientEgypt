package com.evgenii.goncharov.ancient.egypt.utils

import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import android.widget.ImageView
import android.window.SplashScreenView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.evgenii.goncharov.ancient.egypt.MainActivity
import com.evgenii.goncharov.ancient.egypt.R

object SplashHelper {

    fun MainActivity.configSplashScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setOnExitAnimationListener { onExitAnimationListener ->
                val splashRootView = (onExitAnimationListener.view as SplashScreenView)
                val layoutSplash = LayoutInflater.from(baseContext).inflate(
                    R.layout.layout_splash_screen,
                    splashRootView,
                    false
                )
                splashRootView.addView(layoutSplash)
                val splashLogo = (layoutSplash
                    .findViewById<ImageView>(R.id.imv_splash)
                    .drawable as AnimatedVectorDrawable)
                splashLogo.start()
                splashLogo.registerAnimationCallback(
                    object : Animatable2.AnimationCallback() {
                        override fun onAnimationEnd(drawable: Drawable?) {
                            onExitAnimationListener.remove()
                        }
                    }
                )
            }
        }
    }
}