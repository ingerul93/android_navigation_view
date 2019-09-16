package com.ingerul93.navigation.navigation

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.navigation.NavDestination
import androidx.navigation.Navigator
import com.ingerul93.navigation.R

@NavDestination.ClassType(ViewGroup::class)
class ViewDestination(navigator: Navigator<out NavDestination>) : NavDestination(navigator) {

    @LayoutRes var layoutId: Int = 0

    override fun onInflate(context: Context, attrs: AttributeSet) {
        super.onInflate(context, attrs)
        context.resources.obtainAttributes(attrs, R.styleable.ViewNavigator).apply {
            layoutId = getResourceId(R.styleable.ViewNavigator_layoutId, 0)
            recycle()
        }
    }
}
