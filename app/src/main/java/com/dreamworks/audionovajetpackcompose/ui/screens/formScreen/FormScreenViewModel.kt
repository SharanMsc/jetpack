package com.dreamworks.audionovajetpackcompose.ui.screens.formScreen

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormScreenViewModel:ViewModel() {
    val nomeField = MutableLiveData("")
    val cogNomeField = MutableLiveData("")
    val telePhoneField = MutableLiveData("")
    val emailField = MutableLiveData("")
    val capField = MutableLiveData("")
    val policy = MutableLiveData(false)

    val nomeFieldError = MutableLiveData(false)
    val cogNomeFieldError = MutableLiveData(false)
    val telePhoneFieldError = MutableLiveData(false)
    val emailFieldError = MutableLiveData(false)
    val capFieldError = MutableLiveData(false)
    val policyError = MutableLiveData(false)

    private val alphabetOnly = "[a-zA-Z]+".toRegex()



    fun validate():Boolean{
        return if (!alphabetOnly.matches(nomeField.value!!)){
            nomeFieldError.value = true
            false
        }else if (!alphabetOnly.matches(cogNomeField.value!!)){
            cogNomeFieldError.value = true
            false
        }else if (!Patterns.PHONE.matcher(telePhoneField.value!!).matches()){
            telePhoneFieldError.value = true
            false
        }else if (!Patterns.EMAIL_ADDRESS.matcher(emailField.value!!).matches()){
            emailFieldError.value = true
            false
        }else if (!Patterns.PHONE.matcher(capField.value!!).matches()){
            capFieldError.value = true
            false
        }else if (!policy.value!!){
            policyError.value = true
            false
        }else{
            true
        }
    }

}