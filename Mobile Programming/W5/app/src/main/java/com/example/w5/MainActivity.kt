package com.example.w5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.w5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val CALL_REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ITM", "onCreate() called!")

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*        binding.btnSay.setOnClickListener{
            val intent = Intent(this,SubActivity::class.java)
            startActivity(intent)
        }*/

        val intent = Intent(Intent.ACTION_VIEW)
        val chooser = Intent.createChooser(intent, "Show me the Picture!")
        binding.btnSay.setOnClickListener { startActivity(chooser) }

//        binding.btnSay.setOnClickListener { startActivity(intent) }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == CALL_REQUEST_CODE)
    }
}