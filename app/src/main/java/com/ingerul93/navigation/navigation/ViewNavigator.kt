package com.ingerul93.navigation.navigation

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import java.util.*

@Navigator.Name("screen_view")
class ViewNavigator(private val container: ViewGroup) : Navigator<ViewDestination>() {

    private val viewStack: Deque<Pair<Int, Int>> = LinkedList()
    private val navigationHost = container as NavigationHostView

    override fun navigate(
        destination: ViewDestination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Extras?
    ) = destination.apply {
        viewStack.push(Pair(destination.id, destination.layoutId))
        replaceView(navigationHost.getViewForId(destination.layoutId))
    }

    private fun replaceView(view: View?) {
        view?.let {
            container.removeAllViews()
            container.addView(it)
        }
    }

    override fun createDestination(): ViewDestination = ViewDestination(this)

    override fun popBackStack(): Boolean = when {
        viewStack.isNotEmpty() -> {
            viewStack.pop()
            viewStack.peekLast()?.let {
                replaceView(navigationHost.getViewForId(it.second))
            }
            true
        }
        else -> false
    }
}