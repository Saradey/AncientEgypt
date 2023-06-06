package com.evgenii.goncharov.ancient.egypt.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun interface Creator<R> {
    fun create(): R
}

abstract class BaseFragmentScreen : FragmentScreen {

    abstract val baskStackName: String

    companion object {
        operator fun invoke(
            screenKey: String,
            baskStackName: String,
            fragmentCreator: Creator<Fragment>
        ) = object : BaseFragmentScreen() {
            override val screenKey: String = screenKey
            override val baskStackName: String = baskStackName
            override fun createFragment(factory: FragmentFactory): Fragment =
                fragmentCreator.create()
        }
    }
}