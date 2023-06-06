package com.evgenii.goncharov.ancient.egypt.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.Creator
import com.github.terrakok.cicerone.androidx.FragmentScreen

abstract class BaseFragmentScreen : FragmentScreen {

    abstract val baskStackName: String

    companion object {
        operator fun invoke(
            screenKey: String,
            baskStackName: String,
            fragmentCreator: Creator<FragmentFactory, Fragment>
        ) = object : BaseFragmentScreen() {
            override val screenKey: String = screenKey
            override val baskStackName: String = baskStackName
            override fun createFragment(factory: FragmentFactory): Fragment =
                fragmentCreator.create(factory)
        }
    }
}