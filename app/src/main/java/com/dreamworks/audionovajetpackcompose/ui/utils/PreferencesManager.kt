package com.dreamworks.audionovajetpackcompose.ui.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context:Context) {
    private val sendDataFlag = "senFlag"
    private val operatore = "operatore"
    private val location = "location"
    private val pref:SharedPreferences = context.getSharedPreferences("store",Context.MODE_PRIVATE)
    private fun putBoolean(key:String, value:Boolean){
        val editor = pref.edit()
        editor.putBoolean(key,value)
        editor.apply()
    }

    private fun putString(key:String, value:String){
        val editor = pref.edit()
        editor.putString(key,value)
        editor.apply()
    }

    fun storeOperatore(value: String){
        putString(operatore,value)
    }
    fun getOperatore(): String? {
        return pref.getString(operatore,"")
    }

    fun storeLocation(value: String){
        putString(location,value)
    }
    fun getLocation(): String? {
        return pref.getString(location,"")
    }

    fun storeSend(value: Boolean){
        putBoolean(sendDataFlag,value)
    }
    fun getSendFlag():Boolean{
        return pref.getBoolean(sendDataFlag,false)
    }


}