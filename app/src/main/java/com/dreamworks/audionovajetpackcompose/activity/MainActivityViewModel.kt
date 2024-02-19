package com.dreamworks.audionovajetpackcompose.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    val currentScreen = MutableLiveData("")

    fun setCurrentScreen(value:String){
        currentScreen.value = value
    }
}