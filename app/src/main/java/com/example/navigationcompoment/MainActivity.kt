package com.example.navigationcompoment

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        eventHandle()
    }

    private fun eventHandle() {
        /*   btnFirst.setOnClickListener {
               navController?.navigate(R.id.firstFragment)
           }
           btnSecond.setOnClickListener {
               navController?.navigate(R.id.secondFragment)
           }
           btnThird.setOnClickListener {
               navController?.navigate(R.id.thirdFragment)
           }*/
    }

    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bnvMain.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.first -> {
                navController?.navigate(R.id.firstFragment)
            }
            R.id.second -> {
                navController?.navigate(R.id.secondFragment)
            }
            R.id.third -> {
                navController?.navigate(R.id.thirdFragment)
            }
        }
        return true
    }
}