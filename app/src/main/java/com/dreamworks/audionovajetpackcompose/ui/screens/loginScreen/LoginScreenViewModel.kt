package com.dreamworks.audionovajetpackcompose.ui.screens.loginScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dreamworks.audionovajetpackcompose.ui.utils.loginPassword
import com.dreamworks.audionovajetpackcompose.ui.utils.loginUsername

class LoginScreenViewModel:ViewModel() {
    val userName = MutableLiveData("")
    val userNameFocused = MutableLiveData(false)
    val password = MutableLiveData("")
    val passwordFocused = MutableLiveData(false)
    val userNameError = MutableLiveData(false)
    val userPasswordError = MutableLiveData(false)

    fun validate():Boolean{
        return if (userName.value!= loginUsername){
            userNameError.value = true
            false
        }else if (password.value!= loginPassword){
            userPasswordError.value = true
            false
        }else{
            true
        }
    }
}