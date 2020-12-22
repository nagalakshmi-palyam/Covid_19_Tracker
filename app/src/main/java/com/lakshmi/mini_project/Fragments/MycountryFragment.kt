package com.lakshmi.mini_project.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.lakshmi.mini_project.Adapter.MyCountryAdapter
import com.lakshmi.mini_project.Listeners.FragmentClickListener
import com.lakshmi.mini_project.R
import kotlinx.android.synthetic.main.fragment_mycountry.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class MycountryFragment : Fragment(){
    private lateinit var fregmentAdapter:MyCountryAdapter
    private var mFragmentListener: FragmentClickListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mycountry, container, false)
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MycountryFragment().apply {
                arguments = Bundle().apply {
                   getString("statecode")
                }
            }

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPagerAdapter()
        InitializingAndsettingViewPager()
    }
    private fun setViewPagerAdapter() {
        fregmentAdapter = MyCountryAdapter(
            childFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )

    }
    private fun InitializingAndsettingViewPager() {
        statisticsViewPager.adapter =  fregmentAdapter
        tablayoutMycountry.setupWithViewPager(statisticsViewPager)
    }
    fun setFragmentListener(fragmentListener: FragmentClickListener) {
        mFragmentListener = fragmentListener
    }



}