package com.evgenii.goncharov.ancient.egypt.base

import android.view.animation.Animation

abstract class AnimationListenerDefault : Animation.AnimationListener {

    override fun onAnimationStart(animation: Animation?) {}

    override fun onAnimationEnd(animation: Animation?) {}

    override fun onAnimationRepeat(animation: Animation?) {}
}