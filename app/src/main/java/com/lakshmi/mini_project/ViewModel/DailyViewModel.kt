package com.lakshmi.mini_project.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lakshmi.mini_project.Model.ResponseCurrent
import com.lakshmi.mini_project.Model.ResponseDaily
import com.lakshmi.mini_project.Model.ResponseParticularDate
import com.lakshmi.mini_project.Repositry.CurrentRepository
import com.lakshmi.mini_project.Repositry.DailyRepository
import com.lakshmi.mini_project.SealedClass.UserUICurrent
import com.lakshmi.mini_project.SealedClass.UserUIDaily
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DailyViewModel: ViewModel(), Callback<ResponseParticularDate> {
    private val repository= DailyRepository(this)
    private val mutablelist= MutableLiveData<UserUIDaily>()
    val liveData: LiveData<UserUIDaily> = mutablelist

    fun getAPI(){
        repository.getDailyresponse()
    }

    override fun onResponse(
        call: Call<ResponseParticularDate>,
        response: Response<ResponseParticularDate>
    ) {
        response.body()?.let {
            mutablelist.value=UserUIDaily.Success(it as ResponseParticularDate)
        }
    }

    override fun onFailure(call: Call<ResponseParticularDate>, t: Throwable) {
        mutablelist.value=UserUIDaily.Failure(t.message!!)
    }
}