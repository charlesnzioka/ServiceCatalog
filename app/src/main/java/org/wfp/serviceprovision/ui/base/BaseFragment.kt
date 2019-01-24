package org.wfp.serviceprovision.ui.base

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.ui.main.MainActivity

 class BaseFragment :Fragment() {

    private val defaultNavOptions = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
        fun navigateToActivity(context: Context, intent: Intent, navOpts: NavOptions) {
            var navigator= ActivityNavigator(context)
            var dest=navigator.createDestination()
            dest.intent = intent
            //navigator.navigate(dest,null,defaultNavOptions,null)
        }
    }
}