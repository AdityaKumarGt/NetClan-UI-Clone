package com.aditya.netclan.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.aditya.netclan.databinding.ActivityMainBinding
import androidx.core.view.GravityCompat
import com.aditya.netclan.R


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout
        val toolbar = binding.toolBar
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.toolBar,
            R.string.open,
            R.string.close
        )

        toggle.isDrawerIndicatorEnabled = false
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        binding.customIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.refine.setOnClickListener {
            val intent = Intent(this, RefineActivity::class.java)
            startActivity(intent)
        }



        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)


    }
}