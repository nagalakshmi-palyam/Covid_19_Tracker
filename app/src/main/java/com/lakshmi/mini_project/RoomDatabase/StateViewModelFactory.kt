package com.lakshmi.mini_project.RoomDatabase

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lakshmi.mini_project.ViewModel.StateViewModel
import java.security.acl.Owner

class StateViewModelFactory(private val context: Context,private val owner:LifecycleOwner): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if(modelClass.isAssignableFrom(StateViewModel::class.java)){
        return StateViewModel(context,owner) as T
    }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


