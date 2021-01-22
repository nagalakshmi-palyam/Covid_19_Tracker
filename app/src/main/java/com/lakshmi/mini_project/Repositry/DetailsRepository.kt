package com.lakshmi.mini_project.Repositry

import com.lakshmi.mini_project.Apiservice.Apiclient
import com.lakshmi.mini_project.Model.ResponseDaily
import com.lakshmi.mini_project.Network.Network
import retrofit2.Callback

class DetailsRepository(private val callback:Callback<List<ResponseDaily>>) {
    fun getstatedailyDetails(statecode:String){
        val apiclient= Network.getInstance().create(Apiclient::class.java)
        val call=apiclient.getTotalFragment(statecode)
        call.enqueue(callback)
    }
}