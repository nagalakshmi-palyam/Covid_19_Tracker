package com.lakshmi.mini_project.SealedClass

import com.lakshmi.mini_project.Model.ResponseDaily
import com.lakshmi.mini_project.Model.ResponseParticularDate

sealed class UserUIDaily {
    data class Success(val responseDaily:List<ResponseDaily>) : UserUIDaily()
    data class Failure(val error: String) : UserUIDaily()
}