package com.lakshmi.mini_project.Adapter

import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentStatePagerAdapter
//import com.lakshmi.mini_project.Listeners.FragmentClickListener
//
//class Test(
//    fm: FragmentManager,
//    behavior: Int,
//    fragmentClickListener: FragmentClickListener
//) :
//   // FragmentStatePagerAdapter(fm, behavior) {
//    //private val fragmentClickListener: FragmentClickListener
////    override fun getItem(position: Int): Fragment {
////        when (position) {
////            0 -> {
////                val fragmentAlbums = FragmentAlbums()
////                fragmentAlbums.setFragmentListener(fragmentClickListener)
////                return fragmentAlbums
////            }
////            1 -> {
////                val fragmentPlayList = FragmentPlayList()
////                fragmentPlayList.setFragmentListener(fragmentClickListener)
////                return fragmentPlayList
////            }
////        }
////        return FragmentPlayList()
////    }
////
////    override fun getCount(): Int {
////        return 2
////    }
////
////    override fun getPageTitle(position: Int): CharSequence? {
////        when (position) {
////            0 -> return "Albums"
////            1 -> return "PlayLists"
////        }
////        return super.getPageTitle(position)
////    }
////
////    init {
////        this.fragmentClickListener = fragmentClickListener
////    }
////}