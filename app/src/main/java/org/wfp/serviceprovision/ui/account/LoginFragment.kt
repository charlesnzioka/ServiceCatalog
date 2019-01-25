package org.wfp.serviceprovision.ui.account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.ActivityNavigator
import androidx.navigation.navOptions
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.ui.main.MainActivity

class LoginFragment: Fragment(){
    private val viewModel by viewModel<LoginViewModel>()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        if(viewModel.getCurrentUser()!=null){
            //lets navigate away to main page
            navigateToMainPage()

        }
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginEvent.observe(this, Observer { loginEvent->
            if(!loginEvent.isLoading && loginEvent.error!=null){
                Toast.makeText(this.context,loginEvent.error.message,Toast.LENGTH_LONG).show()
            }
            else if(!loginEvent.isLoading && loginEvent.error==null && loginEvent.isSuccess && loginEvent.result!=null){
                viewModel.addCurrentUserToPreferences(loginEvent.result)
                navigateToMainPage()
            }
            if(loginEvent.isLoading){
                btnServerLogin.visibility=View.GONE
            }
            else if(!loginEvent.isLoading){
                btnServerLogin.visibility=View.VISIBLE
            }
        })

        btnServerLogin.setOnClickListener {
            val email=etUserName.text.toString()
            val password=etPassword.text.toString()
            if(viewModel.validEmailAndPassword(email,password)){
                hideKeyboard()
                viewModel.login(email,password)
            }
        }
    }

    private fun navigateToMainPage(){
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

    private fun hideKeyboard() {
        val view = this.activity?.currentFocus
        if (view != null) {
            val imm = this.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm?.hideSoftInputFromWindow(view!!.getWindowToken(), 0)
        }
    }
}