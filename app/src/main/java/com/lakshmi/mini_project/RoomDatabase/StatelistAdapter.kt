package com.lakshmi.mini_project.RoomDatabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.mini_project.Listeners.RecyclerviewItemClickListener
import com.lakshmi.mini_project.R

class StatelistAdapter(private var listOfStates:List<States>,
                       private var listener:DatabaseitemClickListner):
    RecyclerView.Adapter<StateListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateListViewHolder {
        val view=LayoutInflater.from(parent.context).
        inflate(R.layout.state_item_layout,parent,false)
        return StateListViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: StateListViewHolder, position: Int) {
       val data=listOfStates[position]
        holder.setData(data,position)
    }

    override fun getItemCount(): Int {
      return listOfStates.size
    }
    fun updatelist(listOfStates: List<States>){
       this.listOfStates=listOfStates
        notifyDataSetChanged()
    }

}