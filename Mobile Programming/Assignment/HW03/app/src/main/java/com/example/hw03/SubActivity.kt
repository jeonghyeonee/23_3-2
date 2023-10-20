package com.example.hw03

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw03.databinding.ActivityMainBinding

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentPhoneNumber = intent.data?.schemeSpecificPart
        if (intentPhoneNumber != null){
            val resultIntent = Intent()
            resultIntent.putExtra("phoneNumber", intentPhoneNumber)
            setResult(Activity.RESULT_OK, resultIntent)
        }

        finish()
    }
}