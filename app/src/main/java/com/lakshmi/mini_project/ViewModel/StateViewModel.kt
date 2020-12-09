package com.lakshmi.mini_project.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lakshmi.mini_project.Model.ResponseStates
import com.lakshmi.mini_project.Repositry.StateRepositry
import com.lakshmi.mini_project.SealedClass.UserUI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StateViewModel:ViewModel(),Callback<List<ResponseStates>> {
    private val repository= StateRepositry(this)
    private val mutablelist= MutableLiveData<UserUI>()
    val liveData: LiveData<UserUI> = mutablelist


    fun getAPI() {
        repository.getstatelist();
    }
    override fun onResponse(
        call: Call<List<ResponseStates>>,
        response: Response<List<ResponseStates>>
    ) {
        response.body()?.let {
            mutablelist.value=UserUI.Success(it as List<ResponseStates>)
        }
    }

    override fun onFailure(call: Call<List<ResponseStates>>, t: Throwable) {
        mutablelist.value=UserUI.Failure(t.message!!)
    }
    val states=MutableLiveData<String>()
    fun sendStaes(state:String){
        states.value=state
    }

}