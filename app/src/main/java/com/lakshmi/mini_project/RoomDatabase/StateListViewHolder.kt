package com.lakshmi.mini_project.RoomDatabase

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.state_item_layout.view.*

class StateListViewHolder(private val view: View,
                          private val listener: DatabaseitemClickListner)
    :RecyclerView.ViewHolder(view) {
    fun setData(states: States,position:Int){
        view.apply {
            stateName.text=states.stateName
            stateName.setOnClickListener {
                listener.ondatabseItemClicked(states,position);
            }
        }
    }

}