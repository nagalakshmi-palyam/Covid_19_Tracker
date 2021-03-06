package com.lakshmi.mini_project.Fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.lakshmi.mini_project.Activites.MainActivity
import com.lakshmi.mini_project.R
import com.lakshmi.mini_project.RoomDatabase.StateViewModelFactory
import com.lakshmi.mini_project.RoomDatabaseForStatisticsFragment.DetailsViewModelFactory
import com.lakshmi.mini_project.ViewModel.DetailsViewModel
import com.lakshmi.mini_project.ViewModel.StateViewModel
import kotlinx.android.synthetic.main.fragment_total.*
import kotlinx.android.synthetic.main.state_item_layout.*

class TotalFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var dailyViewModel: DetailsViewModel
    private var myState=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dailyViewModel = DetailsViewModelFactory(this.requireContext(),requireActivity()).
        create(DetailsViewModel::class.java)
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context)
        myState=sharedPreferences.getString("state","").toString()
        Toast.makeText(context,myState+"is",Toast.LENGTH_SHORT).show()
        dailyViewModel.getAPI(myState)

       // observeLiveData()
        fetchfromdatabase()


    }
    fun fetchfromdatabase(){
        dailyViewModel.fetchDataFromDB().observe(this, Observer {
            it.let{
                for(i in 0 until it.size){
                    if(it.get(i).affected!=null) {
                        tvaffectednumber.text = it.get(i).affected
                    } else {
                        tvaffectednumber.text="0"
                    }
                    if(it.get(i).deaths!=null) {
                        tvdeathcount.text = it.get(i).deaths
                    } else {
                        tvdeathcount.text ="0"
                    }
                    if(it.get(i).recovered!=null) {
                        tvrecoverednumber.text = it.get(i).recovered
                    } else {
                        tvrecoverednumber.text="0"
                    }
                    if(it.get(i).active!=null) {
                        tvactivecount.text = it.get(i).active
                    } else {
                        tvactivecount.text ="0"
                    }
                    if(it.get(i).serious!=null) {
                        tvseriouscount.text = it.get(i).serious
                    } else {
                        tvseriouscount.text ="0"
                    }
                }
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        val livedata=(requireActivity())
//        stateViewModel.states.observe(this,{
//            Log.d("Lakshmi",it)
//            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
//
//
//        })

    }




}