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
import kotlinx.android.synthetic.main.fragment_yesterday.*

class YesterdayFragment : Fragment() {
    private lateinit var stateViewModel: StateViewModel
    private lateinit var dailyViewModel: DetailsViewModel
   // private lateinit var dailyViewModel: DailyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yesterday, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dailyViewModel = DetailsViewModelFactory(this.requireContext(),requireActivity()).
        create(DetailsViewModel::class.java)
        stateViewModel= StateViewModelFactory(this.requireContext(),requireActivity()).
        create(StateViewModel::class.java)
        dailyViewModel.getAPI("AK")
        //observeState()
        fetchfromdatabase()
    }
    fun fetchfromdatabase(){
        dailyViewModel.fetchDataFromDB().observe(this, Observer {
            it.let{
                for(i in 0 until it.size){
                    tvaffectednumberyesterday.text=it.get(i).affected
                    tvdeathcountyesterday.text=it.get(i).deaths
                    tvrecoverednumberyesterday.text=it.get(i).recovered
                    tvactivecountyesterday.text=it.get(i).active
                    tvseriouscountyesterday.text=it.get(i).serious
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
//        dailyViewModel.liveData.observe(this, {
//            when (it) {
//                is UserUIDailyParticularDate.Success -> {
//                    tvaffectednumberp.text=it.responseParticularDate.total.toString()
//                    tvdeathcountp.text=it.responseParticularDate.death.toString()
//                    tvrecoverednumberp.text=it.responseParticularDate.recovered.toString()
//                    tvactivecountp.text=it.responseParticularDate.positive.toString()
//                }
//
//                is UserUIDailyParticularDate.Failure -> {
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