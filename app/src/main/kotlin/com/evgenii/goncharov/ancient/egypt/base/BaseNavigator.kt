package com.evgenii.goncharov.ancient.egypt.base

import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator

abstract class BaseNavigator(
    protected val fm: FragmentManager,
    protected val ff: FragmentFactory,
    protected val containerId: Int
) : Navigator {

    override fun applyCommands(commands: Array<out Command>) {
        fm.executePendingTransactions()
        for (command in commands) {
            try {
                applyCommand(command)
            } catch (e: RuntimeException) {
                errorOnApplyCommand(e)
            }
        }
    }

    protected abstract fun applyCommand(command: Command)

    private fun errorOnApplyCommand(
        error: RuntimeException
    ) {
        error(
            ERROR_MESSAGE.format(
                this.javaClass.canonicalName,
                TAG,
                error.message
            )
        )
    }

    private companion object {

        const val TAG = "Navigator"
        const val ERROR_MESSAGE =
            "errorOnApplyCommand host: %s tag: %s error message: %s"
    }
}