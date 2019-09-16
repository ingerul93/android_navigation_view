package com.ingerul93.navigation.navigation

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import com.ingerul93.navigation.R

class NavigationHostView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = -1
) : FrameLayout(context, attrs, defStyleAttr), NavHost {

    private val navigationController = NavController(context)

    init {
        Navigation.setViewNavController(this, navigationController)
        val customViewNavigator = ViewNavigator(this)
        navigationController.navigatorProvider.addNavigator(customViewNavigator)
        navigationController.setGraph(R.navigation.navigation)
    }

    override fun getNavController() = navigationController

}
