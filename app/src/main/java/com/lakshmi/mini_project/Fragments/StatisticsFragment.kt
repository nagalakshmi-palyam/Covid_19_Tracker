package com.lakshmi.mini_project.Fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lakshmi.mini_project.Adapter.FragMentAdapter
import com.lakshmi.mini_project.Listeners.FragmentClickListener
import com.lakshmi.mini_project.R
import com.lakshmi.mini_project.RoomDatabase.StateViewModelFactory
import com.lakshmi.mini_project.ViewModel.StateViewModel
import kotlinx.android.synthetic.main.fragment_statistics.*

class StatisticsFragment : Fragment(),FragmentClickListener {
    private lateinit var stateViewModel: StateViewModel
    private lateinit var fregmentAdapter:FragMentAdapter
    var data="";
    private lateinit var sharedPreferences: SharedPreferences




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        print("debug :on create ")

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
//       val  stateViewModel= StateViewModelFactory(requireActivity(),this).create()
//
//        stateViewModel.liveState.observe(viewLifecycleOwner, Observer {
//            Toast.makeText(context,"State is " +it, Toast.LENGTH_SHORT).show()
//        })
//      //  observeState()

        arguments?.let {
            data = it.getString("data").toString()
            Toast.makeText(context,"State is " +data, Toast.LENGTH_SHORT).show()


        }
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("state",data)
        editor.commit()
        InitializingAndsettingViewPager()

    }
    private fun setViewPagerAdapter() {
        fregmentAdapter = FragMentAdapter(
            childFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,this)

    }
    private fun InitializingAndsettingViewPager() {
        ViewPagerstatistics.adapter =  fregmentAdapter
        tbstatistics.setupWithViewPager(ViewPagerstatistics)

    }

    override fun onDatapassed(bundle: Bundle?) {
      bundle?.putString(data,"statecode")
    }
//    fun observeState(){
//        stateViewModel.states.observe(this,{
////            Log.d("Lakshmi",it)
////            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
//            it
//
//        })
//
//    }





}