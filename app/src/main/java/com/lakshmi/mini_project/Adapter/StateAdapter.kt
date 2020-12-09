package com.lakshmi.mini_project.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.mini_project.Listeners.RecyclerviewItemClickListener
import com.lakshmi.mini_project.Model.ResponseStates
import com.lakshmi.mini_project.R
import com.lakshmi.mini_project.ViewHolder.StateViewHolder

class StateAdapter(private var statelist:List<ResponseStates>,private var ItemclickListener:RecyclerviewItemClickListener):
    RecyclerView.Adapter<StateViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.state_item_layout,parent,false)
        return StateViewHolder(view,ItemclickListener)
    }

    override fun onBindViewHolder(holder: StateViewHolder, position: Int) {
         val data=statelist[position]
        holder.setData(data,position)
    }

    override fun getItemCount(): Int {
        return statelist.size

    }
    fun updateStateList(statelist: List<ResponseStates>){
        this.statelist=statelist
        notifyDataSetChanged()
    }
}