package com.example.hw05

import android.app.Application

class MySharedPreferences : Application() {
    companion object {
        lateinit var pref: PreferencesUtil
    }

    override fun onCreate() {
        pref = PreferencesUtil(applicationContext)
        super.onCreate()
    }

}