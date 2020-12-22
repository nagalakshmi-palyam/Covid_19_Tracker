package com.lakshmi.mini_project.SealedClass

import com.lakshmi.mini_project.Model.ResponseParticularDate

sealed class UserUIDailyParticularDate {
    data class Success(val responseParticularDate: ResponseParticularDate) : UserUIDailyParticularDate()
    data class Failure(val error: String) : UserUIDailyParticularDate()
}