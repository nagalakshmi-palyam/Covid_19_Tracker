package com.lakshmi.mini_project.Listeners

import com.lakshmi.mini_project.Model.ResponseStates

interface RecyclerviewItemClickListener {
    fun onItemClicked(responseStates: ResponseStates,position:Int)
}