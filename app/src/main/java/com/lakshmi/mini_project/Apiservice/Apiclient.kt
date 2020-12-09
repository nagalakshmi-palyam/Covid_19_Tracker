package com.lakshmi.mini_project.Apiservice

import com.lakshmi.mini_project.Model.ResponseCurrent
import com.lakshmi.mini_project.Model.ResponseParticularDate
import com.lakshmi.mini_project.Model.ResponseStates
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Apiclient {
    @GET("/v1/states/info.json")
    fun getStates():Call<List<ResponseStates>>
    @GET("/v1/states/{state}/current.json")
    fun getCurrentDetails(@Path("state") state:String):Call<ResponseCurrent>
    @GET("/v1/states/{state}/{date}.json")
    fun getdailyDetails(@Path("state") state:String,@Path("date")
    date:String):Call<ResponseParticularDate>

}