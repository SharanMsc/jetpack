package com.dreamworks.audionovajetpackcompose.ui.screens.settingsScreen

import android.annotation.SuppressLint
import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dreamworks.audionovajetpackcompose.ui.utils.PreferencesManager

class SettingsScreenViewModel : ViewModel() {

    val codiceOperatore = MutableLiveData("")
    val codiceLocation = MutableLiveData("")


    val codiceOperatoreError = MutableLiveData(false)
    val codiceLocationError = MutableLiveData(false)

    fun validate():Boolean{
        return if (codiceOperatore.value!!.isEmpty()){
            codiceOperatoreError.value = true
            false
        }else if (codiceLocation.value!!.isEmpty()){
            codiceLocationError.value = true
            false
        }else{
            true
        }
    }

}