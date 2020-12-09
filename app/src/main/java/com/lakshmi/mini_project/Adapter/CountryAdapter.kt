package com.lakshmi.mini_project.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.annotation.Nullable
import com.lakshmi.mini_project.Model.CountryItem
import com.lakshmi.mini_project.R
import de.hdodenhof.circleimageview.CircleImageView

class CountryAdapter(context: Context?, countryList: ArrayList<CountryItem>) :
    ArrayAdapter<CountryItem?>(context!!, 0, countryList as List<CountryItem?>) {

    override fun getView(position: Int, @Nullable convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(
        position: Int,
        @Nullable convertView: View?,
        parent: ViewGroup
    ): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView=convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.context).inflate(
                R.layout.state_list_spinner, parent, false)

        }
        val imageViewFlag = convertView?.findViewById<CircleImageView>(R.id.image_view_flag)
        val textViewName = convertView?.findViewById<TextView>(R.id.text_view_name)
        val currentItem = getItem(position)
        if (currentItem != null) {
            imageViewFlag?.setImageResource(currentItem.mcountryImage)
            textViewName?.setText(currentItem.mcountryname)
        }
        return convertView!!
    }
}