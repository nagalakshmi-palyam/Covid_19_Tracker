package com.lakshmi.mini_project.ViewModel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.lakshmi.mini_project.Model.ResponseDaily
import com.lakshmi.mini_project.Repositry.DetailsRepository
import com.lakshmi.mini_project.RoomDatabaseForStatisticsFragment.Details
import com.lakshmi.mini_project.RoomDatabaseForStatisticsFragment.DetailsDatabase
import com.lakshmi.mini_project.SealedClass.UserUIDaily
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel(private val context: Context, private val owner: LifecycleOwner) :
    ViewModel(), Callback<List<ResponseDaily>> {
    private val repository = DetailsRepository(this)
    private val mutablelist = MutableLiveData<UserUIDaily>()
    private var statecode = ""
    val liveData: LiveData<UserUIDaily> = mutablelist
    override fun onResponse(
        call: Call<List<ResponseDaily>>,
        response: Response<List<ResponseDaily>>
    ) {
        response.body()?.let {
            //mutablelist.value= UserUIDaily.Success(it as List<ResponseDaily>)
            CoroutineScope(Dispatchers.IO).launch {
                for (i in 0 until it.size) {
                    val details = Details(
                        affected = it[i].total.toString(),
                        recovered = it[i].negative.toString(),
                        deaths = it[i].death.toString(),
                        serious = it[i].positive.toString(),
                        active = it[i].hospitalizedCurrently.toString())
                    DetailsDatabase.getInstance(context).todayDetailsDao.insertDetails(details)
                }
            }
        }
    }

    override fun onFailure(call: Call<List<ResponseDaily>>, t: Throwable) {
        //mutablelist.value= UserUIDaily.Failure(t.message!!)
    }

    fun getAPI(statecode: String) {
        this.statecode = statecode
        // repository.getstatedailyDetails(state)
        DetailsDatabase.getInstance(context).todayDetailsDao.getAllDetails()
            .observe(owner, Observer {
                if (it.isNullOrEmpty()) {
                    repository.getstatedailyDetails(statecode)
                }
            }
            )
    }

    //    fun insertDataToDatabase(affected:String,recovered:String,deaths:String,serious:String,active:String) {
//        CoroutineScope(Dispatchers.IO).launch {
//            val details = TodayDetails(affected = afhttps://github.com/nagalakshmi-palyam/Covid_19_Tracker.gitfected,recovered = recovered,deaths = deaths,
//                serious = serious,active = active)
//            TodayDetailsDatabase.getInstance(context).todayDetailsDao.insertDetails(details)
//        }
//    }
    fun fetchDataFromDB(): LiveData<List<Details>> {
        return DetailsDatabase.getInstance(context)
            .todayDetailsDao.getAllDetails()
    }

}