package com.lakshmi.mini_project.ViewModel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.lakshmi.mini_project.Model.ResponseStates
import com.lakshmi.mini_project.Repositry.StateRepositry
import com.lakshmi.mini_project.RoomDatabase.StateDatabase
import com.lakshmi.mini_project.RoomDatabase.States
import com.lakshmi.mini_project.SealedClass.UserUI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StateViewModel(private val context: Context,private val owner: LifecycleOwner):ViewModel(),Callback<List<ResponseStates>> {
    private val repository= StateRepositry(this)
    private val mutablelist= MutableLiveData<UserUI>()
    val liveData: LiveData<UserUI> = mutablelist


    fun getAPI() {
        StateDatabase.getInstance(context).stateDao.getAllStates().observe(owner, Observer {
            if(it.isNullOrEmpty()){
                repository.getstatelist();
            }
        }
        )
    }
    override fun onResponse(
        call: Call<List<ResponseStates>>,
        response: Response<List<ResponseStates>>
    ) {
        response.body()?.let {
          // mutablelist.value=UserUI.Success(it as List<ResponseStates>)
            CoroutineScope(IO).launch {
                for(i in 0 until it.size) {
                    val states = States(stateName=it[i].name.toString(),state = it[i].state.toString())
                    StateDatabase.getInstance(context).stateDao.insertState(states)
                }
            }

        }
    }

    override fun onFailure(call: Call<List<ResponseStates>>, t: Throwable) {
        //mutablelist.value=UserUI.Failure(t.message!!)
    }
    fun fetchDataFromDB(): LiveData<List<States>> {
        return StateDatabase.getInstance(context)
            .stateDao.getAllStates()
    }

    val states=MutableLiveData<String>()
    val liveState = states

    fun sendStaes(state:String){
        states.value=state
    }


}
    

