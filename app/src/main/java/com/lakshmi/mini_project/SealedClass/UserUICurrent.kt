package com.lakshmi.mini_project.SealedClass

import com.lakshmi.mini_project.Model.ResponseCurrent
import com.lakshmi.mini_project.Model.ResponseStates

sealed class UserUICurrent {
    data class Success(val currentresponse: ResponseCurrent) : UserUICurrent()
    data class Failure(val error: String) : UserUICurrent()
}