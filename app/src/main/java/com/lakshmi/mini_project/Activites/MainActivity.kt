package com.lakshmi.mini_project.Activites

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lakshmi.mini_project.Fragments.HomeFragment
import com.lakshmi.mini_project.Fragments.StatisticsFragment
import com.lakshmi.mini_project.Listeners.RecyclerviewItemClickListener
import com.lakshmi.mini_project.Model.ResponseStates
import com.lakshmi.mini_project.R
import com.lakshmi.mini_project.RoomDatabase.StateViewModelFactory
import com.lakshmi.mini_project.ViewModel.StateViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var stateViewModel: StateViewModel
    lateinit var preferences: SharedPreferences
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
        preferences=getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)
        tvName.text=  preferences.getString("Name","")
        tvlogout.setOnClickListener {
            val editor:SharedPreferences.Editor=preferences.edit()
            editor.clear()
            editor.apply()
            val intent= Intent(this,LogInActivity::class.java)
            startActivity(intent)
            finish()
        }
        ivMenu.setOnClickListener(this)
        layoutslide.setOnClickListener(this)
        stateViewModel= StateViewModelFactory( this,this).
        create(StateViewModel::class.java)
        observeState()

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
        fragmentmanger.beginTransaction().add(R.id.fragment_contaner, HomeFragment()).
        addToBackStack("Homefragment").commit()
    }
    private fun slideRight(){
        val slide = Slide()
        slide.setSlideEdge(Gravity.START)
        TransitionManager.beginDelayedTransition(layoutslide, slide)
        layoutslide.setVisibility(View.VISIBLE)
    }
    private fun slideft(){
        val slide = Slide()
        slide.setSlideEdge(Gravity.START)
        TransitionManager.beginDelayedTransition(layoutslide, slide)
        layoutslide.setVisibility(View.GONE)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ivMenu->{
                slideRight()
            }
            R.id.layoutslide->{
                slideft()
            }
        }
    }
    fun observeState(){
        stateViewModel.states.observe(this,{
            Log.d("siri",it)
            Toast.makeText(this,it, Toast.LENGTH_SHORT).show()

        })

    }


}