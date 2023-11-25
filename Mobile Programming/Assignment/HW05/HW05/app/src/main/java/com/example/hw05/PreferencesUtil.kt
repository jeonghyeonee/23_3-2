package com.example.hw05

import android.content.Context

class PreferencesUtil(context: Context) {
    private val pref = context.getSharedPreferences("prefs", 0)

    //value는 default 값
    fun getString(key:String, value:String) : String{
        return pref.getString(key,value).toString()
    }

    fun setString(key:String, value:String){
        pref.edit().putString(key,value).apply()
    }

    //default value
    fun getBoolean(key:String, value:Boolean):Boolean{
        return pref.getBoolean(key, value)
    }

    fun setBoolean(key:String, value:Boolean){
        pref.edit().putBoolean(key,value).apply()
    }
}
