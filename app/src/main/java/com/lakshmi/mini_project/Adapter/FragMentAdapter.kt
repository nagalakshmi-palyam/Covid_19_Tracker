package com.lakshmi.mini_project.Adapter

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.lakshmi.mini_project.Fragments.*

class FragMentAdapter(fm: FragmentManager, behavior: Int) :

    FragmentStatePagerAdapter(fm, behavior) {

    override fun getCount(): Int {
        return 2

    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                val mycountryFragment:MycountryFragment=MycountryFragment()
                return MycountryFragment.newInstance("MyFragment","Myfragment")
            }
            1 -> {
                return GlobalFragment()

            }
        }
        return MycountryFragment.newInstance("MyFragment","Myfragment")
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        var tabTitle = ""
        tabTitle = when (position) {
            0 -> "My Country"
            1 -> "Global"
            else -> "TAB - n"
        }
        return tabTitle
    }
}