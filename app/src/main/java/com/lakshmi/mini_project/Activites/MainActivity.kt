package com.lakshmi.mini_project.Activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lakshmi.mini_project.Fragments.HomeFragment
import com.lakshmi.mini_project.Fragments.StatisticsFragment
import com.lakshmi.mini_project.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var selectedFragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initviews()
    }
    private fun initviews() {
        bottomNavigationView= BottomNavigationView(this)
        bottom_navigation.setOnNavigationItemSelectedListener(navigationItemSelectedlistener)
        launchHomefragment()

    }
    private val navigationItemSelectedlistener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> selectedFragment = HomeFragment()
                R.id.nav_statistics -> selectedFragment = StatisticsFragment()
            }
            if (selectedFragment != null) {
                val fragmentmanger = supportFragmentManager
                fragmentmanger.beginTransaction().replace(
                    R.id.fragment_contaner,
                    selectedFragment!!
                ).commit()
            }
            true
        }
    fun launchHomefragment(){
        val fragmentmanger = supportFragmentManager
        fragmentmanger.beginTransaction().add(R.id.fragment_contaner, HomeFragment()).commit()
    }




}