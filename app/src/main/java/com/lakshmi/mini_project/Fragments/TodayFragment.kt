package com.lakshmi.mini_project.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.lakshmi.mini_project.R
import com.lakshmi.mini_project.SealedClass.UserUICurrent
import com.lakshmi.mini_project.ViewModel.CurrentDetailsViewModel
import com.lakshmi.mini_project.ViewModel.StateViewModel
import kotlinx.android.synthetic.main.fragment_today.*
import kotlinx.android.synthetic.main.fragment_total.*

class TodayFragment : Fragment() {
    private lateinit var stateViewModel: StateViewModel
    private lateinit var currentDetailsViewModel: CurrentDetailsViewModel
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
        stateViewModel=ViewModelProvider(this).get(StateViewModel::class.java)
        observeState();

    }
    fun observeState(){
        stateViewModel.states.observe(this,{
            Log.d("Lakshmi",it)
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
            currentDetailsViewModel= ViewModelProvider(this).get(CurrentDetailsViewModel::class.java)
            observeLiveData()
            currentDetailsViewModel.getAPI(it)
        })
    }


    private fun observeLiveData() {
        currentDetailsViewModel.liveData.observe(this, {
            when (it) {
                is UserUICurrent.Success -> {
                    tvaffectednumbertoday.text=it.currentresponse.total.toString()
                    tvdeathcounttoday.text=it.currentresponse.death.toString()
                    tvrecoverednumbertoday.text=it.currentresponse.recovered.toString()
                    tvactivecounttoday.text=it.currentresponse.positive.toString()
                }

                is UserUICurrent.Failure -> {
                    Toast.makeText(
                        requireActivity(),
                        "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }


}


