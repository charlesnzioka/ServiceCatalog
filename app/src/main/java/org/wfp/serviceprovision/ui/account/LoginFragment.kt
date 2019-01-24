package org.wfp.serviceprovision.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigator
import androidx.navigation.navOptions
import kotlinx.android.synthetic.main.fragment_login.*
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.ui.main.MainActivity

class LoginFragment: Fragment(){
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnServerLogin.setOnClickListener {
            val options = navOptions {
                anim {
                    enter = R.anim.slide_in_right
                    exit = R.anim.slide_out_left
                    popEnter = R.anim.slide_in_left
                    popExit = R.anim.slide_out_right
                }
            }
            var navigator=ActivityNavigator(this.context!!)
            var dest=navigator.createDestination()
            dest.intent = Intent(this.context,MainActivity::class.java)
            navigator.navigate(dest,null,options,null)
            this.activity?.finish()
        }
    }
}