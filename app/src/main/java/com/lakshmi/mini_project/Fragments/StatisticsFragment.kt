package com.lakshmi.mini_project.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import com.lakshmi.mini_project.Adapter.FragMentAdapter
import com.lakshmi.mini_project.Adapter.MyCountryAdapter
import com.lakshmi.mini_project.R
import com.lakshmi.mini_project.ViewModel.StateViewModel
import kotlinx.android.synthetic.main.fragment_statistics.*

class StatisticsFragment : Fragment() {
    private lateinit var fregmentAdapter:FragMentAdapter
    private lateinit var stateViewModel: StateViewModel
    private  var stateName:String=" "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPagerAdapter()
        InitializingAndsettingViewPager()
    }
    private fun setViewPagerAdapter() {
        fregmentAdapter = FragMentAdapter(
            childFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)

    }
    private fun InitializingAndsettingViewPager() {
        ViewPagerstatistics.adapter =  fregmentAdapter
        tbstatistics.setupWithViewPager(ViewPagerstatistics)
        stateViewModel=ViewModelProvider(this).get(StateViewModel::class.java)
        observeState()
    }
    fun observeState(){
     stateViewModel.states.observe(this,{
         stateName=it
         Log.d("Lakshmi",stateName)
         Toast.makeText(context,stateName,Toast.LENGTH_SHORT).show()
     })
    }




}