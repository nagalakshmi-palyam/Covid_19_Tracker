package com.lakshmi.mini_project.Repositry

import com.lakshmi.mini_project.Apiservice.Apiclient
import com.lakshmi.mini_project.Model.ResponseCurrent
import com.lakshmi.mini_project.Model.ResponseParticularDate
import com.lakshmi.mini_project.Network.Network
import retrofit2.Callback

class DailyRepositoryForParticularDate(private val callback: Callback<ResponseParticularDate>) {
    fun getDailyresponse(){
        val apiclient= Network.getInstance().create(Apiclient::class.java)
        val call=apiclient.getdailyDetails("ca","20201207")
        call.enqueue(callback)
    }
}
