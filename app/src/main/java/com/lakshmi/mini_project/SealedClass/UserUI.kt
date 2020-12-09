package com.lakshmi.mini_project.SealedClass

import com.lakshmi.mini_project.Model.ResponseStates

sealed  class UserUI {
data class Success(val stateslist:List<ResponseStates>):UserUI()
    data class Failure(val error:String):UserUI()
}