package com.example.w4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.w4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

/*        // Set the TextView Text
        val tView: TextView = findViewById(R.id.txtSay)
        tView.text = "This code will change the string!"

        // Button Click > disappear TextView
        val tBtn: Button = findViewById(R.id.btnSay)
        tBtn.setOnClickListener{
            tView.visibility = View.INVISIBLE*/

        // ViewBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSay.setOnClickListener {
            binding.txtSay.text = "I love Android!"
        }
        Log.d("ITM", "onCreate called()!")

        val intent = Intent(this, MainActivity2::class.java)
        binding.btnSay.setOnClickListener { startActivity(intent) }

/*        binding.btnSay.setOnClickListener{
            binding.txtSay.text = "I love Android!"

        }*/
    }

    override fun onStart() {
        super.onStart()
        Log.d("ITM", "onStart called()!")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ITM", "onResume called()!")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ITM", "onPause called()!")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ITM", "onStop called()!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ITM", "onDestroy called()!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ITM", "onRestart called()!")
    }


}