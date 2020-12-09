package com.lakshmi.mini_project.Repositry

import com.lakshmi.mini_project.Apiservice.Apiclient
import com.lakshmi.mini_project.Model.ResponseStates
import com.lakshmi.mini_project.Network.Network
import retrofit2.Callback

class StateRepositry(private val callback: Callback<List<ResponseStates>>)
{
    fun getstatelist(){
        val apiclient= Network.getInstance().create(Apiclient::class.java)
        val call=apiclient.getStates()
        call.enqueue(callback)

    }
}
