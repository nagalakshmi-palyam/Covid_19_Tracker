package com.lakshmi.mini_project.Adapter

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.lakshmi.mini_project.Fragments.*
import com.lakshmi.mini_project.Listeners.FragmentClickListener

class FragMentAdapter(fm: FragmentManager, behavior: Int,private val fragmentClickListener: FragmentClickListener) :
    FragmentStatePagerAdapter(fm, behavior) {
    override fun getCount(): Int {
        return 2

    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                val mycountryFragment:MycountryFragment=MycountryFragment()
                mycountryFragment.setFragmentListener(fragmentClickListener)
                return mycountryFragment
            }
            1 -> {
                return GlobalFragment()

            }
        }
        val mycountryFragment:MycountryFragment=MycountryFragment()
        return mycountryFragment
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