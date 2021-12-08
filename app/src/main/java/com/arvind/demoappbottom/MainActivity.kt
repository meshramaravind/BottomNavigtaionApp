package com.arvind.demoappbottom

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.arvind.demoappbottom.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_DemoAppBottom)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews(binding)

    }

    private fun initViews(binding: ActivityMainBinding) {
        navController = findNavController(R.id.nav_host_fragment_activity_main)

        setSupportActionBar(binding.toolbar)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {

                R.id.welcomeFragment -> {
                    supportActionBar!!.setDisplayShowTitleEnabled(false)
                    binding.navView.visibility = View.GONE

                }

                R.id.SignInFragment -> {
                    supportActionBar!!.setDisplayShowTitleEnabled(true)
                    binding.navView.visibility = View.GONE
                }

                R.id.SignUpFragment -> {
                    supportActionBar!!.setDisplayShowTitleEnabled(true)
                    binding.navView.visibility = View.GONE
                }

                R.id.otpFragment -> {
                    supportActionBar!!.setDisplayShowTitleEnabled(true)
                    binding.navView.visibility = View.GONE
                }

                else -> {
                    binding.navView.visibility = View.VISIBLE
                    supportActionBar!!.setDisplayShowTitleEnabled(true)

                }

            }
        }

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.dashboardFragment,
                R.id.notificationsFragment,
                R.id.welcomeFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}