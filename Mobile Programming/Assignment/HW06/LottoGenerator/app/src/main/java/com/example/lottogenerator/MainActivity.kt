package com.example.lottogenerator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.lottogenerator.databinding.ActivityMainBinding
import com.example.lottogenerator.AppDatabase
import com.example.lottogenerator.LottoDao
import com.example.lottogenerator.LottoEntity
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {
    val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}
    lateinit var db : AppDatabase
    lateinit var lottoDao : LottoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // get db instance
        db = AppDatabase.getInstance(this)!!
        // get DAO to do DB task
        lottoDao = db.getLottoDao()

        binding.button.setOnClickListener{

            var lottoList = ArrayList(getRandomLottoNumbers())
            val lottoNum1 = lottoList[0].toString()
            val lottoNum2 = lottoList[1].toString()
            val lottoNum3 = lottoList[2].toString()
            val lottoNum4 = lottoList[3].toString()
            val lottoNum5 = lottoList[4].toString()
            val lottoNum6 = lottoList[5].toString()
            Log.d("ITM","btn click : $lottoNum1, $lottoNum2, $lottoNum3, $lottoNum4, $lottoNum5, $lottoNum6 ")

            // background thread for database task
            Thread{
                lottoDao.insertLotto(LottoEntity(null,lottoNum1,lottoNum2,lottoNum3,lottoNum4,lottoNum5,lottoNum6))
            }.start()

            val intent = Intent(this, Lotto::class.java)
            // pass random number list
            intent.putIntegerArrayListExtra("result",lottoList)
            startActivity(intent)
        }

        binding.subBtn.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }
    // create random number between 1 to 45
    fun getRandomNumber(): Int{
        return Random().nextInt(45)+1
    }

    fun getRandomLottoNumbers(): MutableList<Int>{

        val lottoNumbers = mutableListOf<Int>()

        for(i in 1..6){

            var num = 0
            do {
                num = getRandomNumber() // allocate random number in tmp
            } while(lottoNumbers.contains(num)) // not have duplicate ones

            // store 6 random numbers in the list
            lottoNumbers.add(num)
        }
        Log.d("ITM","lottoNumbers : $lottoNumbers")

        return lottoNumbers
    }

}