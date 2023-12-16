package com.example.lottogenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hw6.databinding.ActivityLottoBinding
import com.example.hw6.databinding.ActivityMainBinding
import com.example.hw6.db.AppDatabase
import com.example.hw6.db.LottoDao
import com.example.hw6.db.LottoEntity

class Lotto : AppCompatActivity() {
    val binding by lazy{ ActivityLottoBinding.inflate(layoutInflater)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // bring result array (random 6 numbers) received from Main activity
        val result = intent.getIntegerArrayListExtra("result")
        Log.d("ITM","$result")

        //implement if result is not null
        result?.let{
            //put received result into each textView text
            binding.num1.text = result[0].toString()
            binding.num2.text = result[1].toString()
            binding.num3.text = result[2].toString()
            binding.num4.text = result[3].toString()
            binding.num5.text = result[4].toString()
            binding.num6.text = result[5].toString()

        }

    }
}