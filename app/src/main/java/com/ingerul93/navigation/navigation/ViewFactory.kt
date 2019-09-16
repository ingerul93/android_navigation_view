package com.ingerul93.navigation.navigation

import android.view.View
import androidx.annotation.IdRes
import androidx.navigation.findNavController
import com.ingerul93.navigation.R
import com.ingerul93.navigation.views.FirstView
import com.ingerul93.navigation.views.LastView
import com.ingerul93.navigation.views.SecondView
import com.ingerul93.navigation.views.ThirdView

fun NavigationHostView.getViewForId(layoutId: Int) = when (layoutId) {
    R.layout.screen_view_first -> FirstView(context)
    R.layout.screen_view_second -> SecondView(context)
    R.layout.screen_view_third -> ThirdView(context)
    R.layout.screen_view_last -> LastView(context)
    else -> null
}

fun View.navigateTo(@IdRes idRes: Int) = findNavController().navigate(idRes)
