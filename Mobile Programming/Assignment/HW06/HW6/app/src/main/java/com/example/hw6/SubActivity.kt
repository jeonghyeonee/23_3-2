package com.example.hw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw6.databinding.ActivitySubBinding
import com.example.hw6.db.AppDatabase
import com.example.hw6.db.LottoDao
import com.example.hw6.db.LottoEntity


class SubActivity : AppCompatActivity() {
    val binding by lazy{ ActivitySubBinding.inflate(layoutInflater)}
    private lateinit var db : AppDatabase
    private lateinit var lottoDao: LottoDao
    private lateinit var lottoList: ArrayList<LottoEntity>
    private lateinit var adapter: LottoRecyclerViewAdapter //recyclerview need adapter & layout manager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // get db instance
        db = AppDatabase.getInstance(this)!!
        // get DAO to do sth in database
        lottoDao = db.getLottoDao()

        getAllLottoList()

        binding.deletebtn.setOnClickListener{
            // database clear
            Thread{
                lottoDao.deleteLotto(lottoList[0])
                lottoDao.deleteLotto(lottoList[1])
                lottoDao.deleteLotto(lottoList[2])
                lottoDao.deleteLotto(lottoList[3])
                lottoDao.deleteLotto(lottoList[4])
                lottoDao.deleteLotto(lottoList[5])

                lottoList.clear()
                runOnUiThread{
                    adapter.notifyDataSetChanged()
                }
            }.start()
        }
    }
    // get all data list stored in DB
    private fun getAllLottoList() {
        Thread{
            lottoList = ArrayList(lottoDao.getAll())
            setRecyclerView()
        }.start()
    }

    private fun setRecyclerView(){
        runOnUiThread{
            adapter = LottoRecyclerViewAdapter(lottoList)
            // set recyclerView adapter using adapter
            binding.recyclerView.adapter = adapter
            // set layout manager
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }
    // call when activity stop and restart
    override fun onRestart(){
        super.onRestart()
        getAllLottoList()
    }

    private fun deleteLotto(){

    }
}