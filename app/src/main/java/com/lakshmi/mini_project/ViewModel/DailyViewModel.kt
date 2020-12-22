package com.lakshmi.mini_project.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lakshmi.mini_project.Model.ResponseParticularDate
import com.lakshmi.mini_project.Repositry.DailyRepositoryForParticularDate
import com.lakshmi.mini_project.SealedClass.UserUIDailyParticularDate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DailyViewModel: ViewModel(), Callback<ResponseParticularDate> {
    private val repository= DailyRepositoryForParticularDate(this)
    private val mutablelist= MutableLiveData<UserUIDailyParticularDate>()
    val liveData: LiveData<UserUIDailyParticularDate> = mutablelist

    fun getAPI(){
        repository.getDailyresponse()
    }

    override fun onResponse(
        call: Call<ResponseParticularDate>,
        response: Response<ResponseParticularDate>
    ) {
        response.body()?.let {
            mutablelist.value=UserUIDailyParticularDate.Success(it as ResponseParticularDate)
        }
    }

    override fun onFailure(call: Call<ResponseParticularDate>, t: Throwable) {
        mutablelist.value=UserUIDailyParticularDate.Failure(t.message!!)
    }
}