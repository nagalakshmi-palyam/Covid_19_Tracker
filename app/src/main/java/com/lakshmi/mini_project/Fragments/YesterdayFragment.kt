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
import com.lakshmi.mini_project.SealedClass.UserUIDaily
import com.lakshmi.mini_project.ViewModel.CurrentDetailsViewModel
import com.lakshmi.mini_project.ViewModel.DailyViewModel
import kotlinx.android.synthetic.main.fragment_total.*
import kotlinx.android.synthetic.main.fragment_yesterday.*

class YesterdayFragment : Fragment() {
    private lateinit var dailyViewModel: DailyViewModel
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
        dailyViewModel= ViewModelProvider(this).get(DailyViewModel::class.java)
        observeLiveData()
        dailyViewModel.getAPI()
    }
    private fun observeLiveData() {
        dailyViewModel.liveData.observe(this, {
            when (it) {
                is UserUIDaily.Success -> {
                    tvaffectednumberp.text=it.responseParticularDate.total.toString()
                    tvdeathcountp.text=it.responseParticularDate.death.toString()
                    tvrecoverednumberp.text=it.responseParticularDate.recovered.toString()
                    tvactivecountp.text=it.responseParticularDate.positive.toString()
                }

                is UserUIDaily.Failure -> {
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