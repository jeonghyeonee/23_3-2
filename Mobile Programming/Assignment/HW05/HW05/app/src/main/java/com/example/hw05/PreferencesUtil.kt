package com.example.hw05

import android.content.Context

// Utility class for handling SharedPreferences operations
class PreferencesUtil(context: Context) {

    // SharedPreferences instance initialized with the provided context and "prefs" file
    private val pref = context.getSharedPreferences("prefs", 0)

    // Get a String value from SharedPreferences, with a default value if the key is not found
    fun getString(key: String, defaultValue: String): String {
        return pref.getString(key, defaultValue).toString()
    }

    // Set a String value in SharedPreferences
    fun setString(key: String, value: String) {
        pref.edit().putString(key, value).apply()
    }

    // Get a Boolean value from SharedPreferences, with a default value if the key is not found
    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return pref.getBoolean(key, defaultValue)
    }

    // Set a Boolean value in SharedPreferences
    fun setBoolean(key: String, value: Boolean) {
        pref.edit().putBoolean(key, value).apply()
    }
}
