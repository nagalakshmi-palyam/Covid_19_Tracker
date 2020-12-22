package com.lakshmi.mini_project.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.lakshmi.mini_project.R
import com.lakshmi.mini_project.RoomDatabase.StateViewModelFactory
import com.lakshmi.mini_project.RoomDatabaseForStatisticsFragment.DetailsViewModelFactory
import com.lakshmi.mini_project.ViewModel.DetailsViewModel
import com.lakshmi.mini_project.ViewModel.StateViewModel
import kotlinx.android.synthetic.main.fragment_today.*

class TodayFragment : Fragment() {
    private lateinit var stateViewModel: StateViewModel
    private lateinit var dailyViewModel: DetailsViewModel
    //private lateinit var statelistViewModel: StateListViewModel
   // private lateinit var statelistViewmodel:StateListViewModel
   // private lateinit var currentDetailsViewModel: CurrentDetailsViewModel
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
       // observeState()
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
//    fun observeState(){
//        stateViewModel.states.observe(this,{
//            Log.d("Lakshmi",it)
//            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
//            dailyViewModel.getAPI("it")
//        })
//
//    }


//    private fun observeLiveData() {
//        currentDetailsViewModel.liveData.observe(this, {
//            when (it) {
//                is UserUICurrent.Success -> {
//                    tvaffectednumbertoday.text=it.currentresponse.total.toString()
//                    tvdeathcounttoday.text=it.currentresponse.death.toString()
//                    tvrecoverednumbertoday.text=it.currentresponse.recovered.toString()
//                    tvactivecounttoday.text=it.currentresponse.positive.toString()
//                }
//
//                is UserUICurrent.Failure -> {
//                    Toast.makeText(
//                        requireActivity(),
//                        "Error message ${it.error}",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        })
//    }


}


