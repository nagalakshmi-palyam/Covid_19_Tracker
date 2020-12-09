package com.lakshmi.mini_project.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lakshmi.mini_project.Model.ResponseCurrent
import com.lakshmi.mini_project.Model.ResponseStates
import com.lakshmi.mini_project.Repositry.CurrentRepository
import com.lakshmi.mini_project.Repositry.StateRepositry
import com.lakshmi.mini_project.SealedClass.UserUI
import com.lakshmi.mini_project.SealedClass.UserUICurrent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentDetailsViewModel:ViewModel(),Callback<ResponseCurrent> {
    private val repository= CurrentRepository(this)
    private val mutablelist= MutableLiveData<UserUICurrent>()
    val liveData: LiveData<UserUICurrent> = mutablelist
    override fun onResponse(call: Call<ResponseCurrent>, response: Response<ResponseCurrent>) {
        response.body()?.let {
            mutablelist.value=UserUICurrent.Success(it as ResponseCurrent)
        }
    }

    override fun onFailure(call: Call<ResponseCurrent>, t: Throwable) {
        mutablelist.value=UserUICurrent.Failure(t.message!!)
    }


}