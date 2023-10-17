package com.example.w3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Function
        // Unit
        printHello("Hey!")
        printHello(null)


    }

    // Functions
    // Unit
    fun printHello(name: String?): Unit{
        if(name != null)
            Log.d("ITM", "Hello $name")
        else
            Log.d("ITM", "Hi there!")
        // 'return Unit' or 'return' is optional
    }
}