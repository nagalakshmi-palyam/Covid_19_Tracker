package com.lakshmi.mini_project.Adapter

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.lakshmi.mini_project.Fragments.TodayFragment
import com.lakshmi.mini_project.Fragments.TotalFragment
import com.lakshmi.mini_project.Fragments.YesterdayFragment

class MyCountryAdapter (fm: FragmentManager, behavior: Int) :

    FragmentStatePagerAdapter(fm, behavior) {

    override fun getCount(): Int {
        return 3

    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0->{
                return TotalFragment()
            }
            1->{
                return TodayFragment()

            }
            2->{
                return YesterdayFragment()

            }
        }
        return TotalFragment()
    }
    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        var tabTitle = ""
        tabTitle = when (position) {
            0 -> "Total"
            1 -> "Today"
            2 -> "Yesterday"
            else -> "TAB - n"
        }
        return tabTitle
    }
}