package com.lakshmi.mini_project.Repositry

import com.lakshmi.mini_project.Apiservice.Apiclient
import com.lakshmi.mini_project.Model.ResponseCurrent
import com.lakshmi.mini_project.Network.Network
import retrofit2.Callback

class CurrentRepository(private val callback:Callback<ResponseCurrent>) {
    fun getstatecurrentlist(){
        val apiclient= Network.getInstance().create(Apiclient::class.java)
        val call=apiclient.getCurrentDetails("ca")
        call.enqueue(callback)
    }
}