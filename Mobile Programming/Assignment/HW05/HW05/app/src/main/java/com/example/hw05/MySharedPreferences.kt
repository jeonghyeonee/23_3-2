package com.example.hw05

import android.app.Application

// Custom Application class to initialize shared preferences utility
class MySharedPreferences : Application() {

    // Companion object to hold a reference to the PreferencesUtil instance
    companion object {
        // Late-initialized variable to hold the PreferencesUtil instance
        lateinit var pref: PreferencesUtil
    }

    // Called when the application is first created
    override fun onCreate() {
        // Initialize the PreferencesUtil instance with the application context
        pref = PreferencesUtil(applicationContext)
        super.onCreate()
    }
}
