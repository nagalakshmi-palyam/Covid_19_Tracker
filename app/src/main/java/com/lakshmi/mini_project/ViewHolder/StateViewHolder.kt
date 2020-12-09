package com.lakshmi.mini_project.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.mini_project.Listeners.RecyclerviewItemClickListener
import com.lakshmi.mini_project.Model.ResponseStates
import kotlinx.android.synthetic.main.state_item_layout.view.*

class StateViewHolder(private val view : View,private var itemClickListener: RecyclerviewItemClickListener): RecyclerView.ViewHolder(view) {
    fun setData(responseStates: ResponseStates,position:Int){
        view.apply {
          stateName.text=responseStates.name
            stateName.setOnClickListener {
                itemClickListener.onItemClicked(responseStates,position)
            }
        }
    }

}