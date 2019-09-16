package com.ingerul93.navigation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.ingerul93.navigation.R
import com.ingerul93.navigation.navigation.navigateTo
import kotlinx.android.synthetic.main.screen_view_first.view.*

class FirstView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = -1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.screen_view_first, this)
        btn_second_screen.setOnClickListener {
            navigateTo(R.id.action_first_screen_view_to_second_screen_view)
        }
        btn_last_screen.setOnClickListener {
            navigateTo(R.id.action_first_screen_view_to_last_screen_view)
        }
    }
}
