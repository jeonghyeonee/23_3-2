package com.example.hw6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.hw6.databinding.ActivityMainBinding
import com.example.hw6.db.AppDatabase
import com.example.hw6.db.LottoDao
import com.example.hw6.db.LottoEntity
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {
    // Using ViewBinding for UI elements
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // Database and DAO instances
    lateinit var db: AppDatabase
    lateinit var lottoDao: LottoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Initializing the Room database and DAO
        db = AppDatabase.getInstance(this)!!
        lottoDao = db.getLottoDao()

        // Button click listener for generating lotto numbers
        binding.button.setOnClickListener {
            // Generate a list of random lotto numbers
            var lottoList = ArrayList(getRandomLottoNumbers())

            // Extract individual lotto numbers as strings
            val lottoNum1 = lottoList[0].toString()
            val lottoNum2 = lottoList[1].toString()
            val lottoNum3 = lottoList[2].toString()
            val lottoNum4 = lottoList[3].toString()
            val lottoNum5 = lottoList[4].toString()
            val lottoNum6 = lottoList[5].toString()

            // Log the generated lotto numbers
            Log.d("ITM", "btn click : $lottoNum1, $lottoNum2, $lottoNum3, $lottoNum4, $lottoNum5, $lottoNum6 ")

            // Insert the generated lotto numbers into the Room database on a separate thread
            Thread {
                lottoDao.insertLotto(LottoEntity(null, lottoNum1, lottoNum2, lottoNum3, lottoNum4, lottoNum5, lottoNum6))
            }.start()

            // Start the Lotto activity to display the generated lotto numbers
            val intent = Intent(this, Lotto::class.java)
            intent.putIntegerArrayListExtra("result", lottoList)
            startActivity(intent)
        }

        // Button click listener for navigating to SubActivity
        binding.subBtn.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }

    // Function to generate a random number between 1 and 45
    fun getRandomNumber(): Int {
        return Random().nextInt(45) + 1
    }

    // Function to generate a list of random lotto numbers
    fun getRandomLottoNumbers(): MutableList<Int> {
        val lottoNumbers = mutableListOf<Int>()

        for (i in 1..6) {
            var num = 0
            do {
                num = getRandomNumber()
            } while (lottoNumbers.contains(num))

            lottoNumbers.add(num)
        }

        // Log the generated lotto numbers
        Log.d("ITM", "lottoNumbers : $lottoNumbers")

        return lottoNumbers
    }
}
