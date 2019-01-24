package org.wfp.serviceprovision.ui.account

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import kotlinx.android.synthetic.main.activity_main.*
import org.wfp.serviceprovision.R

class AccountActivity:AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        initNav()
    }

    private fun initNav(){
        val host: NavHostFragment = supportFragmentManager
                .findFragmentById(R.id.account_nav_host_fragment) as NavHostFragment? ?: return
        navController = host.navController

        supportActionBar?.hide()

    }
}