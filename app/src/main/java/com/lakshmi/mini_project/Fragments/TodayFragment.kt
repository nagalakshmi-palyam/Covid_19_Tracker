package com.lakshmi.mini_project.Fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.lakshmi.mini_project.R
import com.lakshmi.mini_project.RoomDatabase.StateViewModelFactory
import com.lakshmi.mini_project.RoomDatabaseForStatisticsFragment.DetailsViewModelFactory
import com.lakshmi.mini_project.ViewModel.DetailsViewModel
import com.lakshmi.mini_project.ViewModel.StateViewModel
import kotlinx.android.synthetic.main.fragment_today.*

class TodayFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var stateViewModel: StateViewModel
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
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dailyViewModel = DetailsViewModelFactory(this.requireContext(),requireActivity()).
        create(DetailsViewModel::class.java)
        stateViewModel= StateViewModelFactory(this.requireContext(),requireActivity()).
        create(StateViewModel::class.java)
         sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context)
         myState=sharedPreferences.getString("state","").toString()
        Toast.makeText(context,myState+"is",Toast.LENGTH_SHORT).show()
         dailyViewModel.getAPI(myState)
        fetchfromdatabase()

    }
    fun fetchfromdatabase(){
        dailyViewModel.fetchDataFromDB().observe(this, Observer {
            it.let{
                for(i in 0 until it.size){
                    tvaffectednumbertoday.text=it.get(i).affected
                    tvdeathcounttoday.text=it.get(i).deaths
                    tvrecoverednumbertoday.text=it.get(i).recovered
                    tvactivecounttoday.text=it.get(i).active
                    tvseriouscounttoady.text=it.get(i).serious
                }
            }
        })
    }

}



