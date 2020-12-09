package com.lakshmi.mini_project.SealedClass

import com.lakshmi.mini_project.Model.ResponseCurrent
import com.lakshmi.mini_project.Model.ResponseParticularDate

sealed class UserUIDaily {
    data class Success(val responseParticularDate: ResponseParticularDate) : UserUIDaily()
    data class Failure(val error: String) : UserUIDaily()
}