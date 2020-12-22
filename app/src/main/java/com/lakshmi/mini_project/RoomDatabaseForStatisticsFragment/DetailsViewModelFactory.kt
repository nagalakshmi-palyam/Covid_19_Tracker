package com.lakshmi.mini_project.RoomDatabaseForStatisticsFragment

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lakshmi.mini_project.ViewModel.DetailsViewModel


class DetailsViewModelFactory(private val context: Context, private val owner: LifecycleOwner): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(context,owner) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}