package com.example.lottogenerator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6.databinding.ItemLottoBinding
import com.example.hw6.db.LottoEntity
import com.example.lottogenerator.databinding.ItemLottoBinding

// ViewHolder Pattern : Patterns that keep each view object in the view holder to improve speed by reducing repetitive method calls
class LottoRecyclerViewAdapter(private val lottoList: ArrayList<LottoEntity>) : RecyclerView.Adapter<LottoRecyclerViewAdapter.MyViewHolder>(){


    inner class MyViewHolder(binding : ItemLottoBinding):RecyclerView.ViewHolder(binding.root){
        val a_t1 = binding.t1
        val a_t2 = binding.t2
        val a_t3 = binding.t3
        val a_t4 = binding.t4
        val a_t5 = binding.t5
        val a_t6 = binding.t6
        // root layout
        val root = binding.root
    }
    // create ViewHolder instance
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create item_lotto.xml view binding instance
        val binding : ItemLottoBinding = ItemLottoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    // put received parameter into ViewHolder object
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val lottoData = lottoList[position]
        // change lotto text
        holder.a_t1.text = lottoData.lotto1
        holder.a_t2.text = lottoData.lotto2
        holder.a_t3.text = lottoData.lotto3
        holder.a_t4.text = lottoData.lotto4
        holder.a_t5.text = lottoData.lotto5
        holder.a_t6.text = lottoData.lotto6
    }
    // number of item of recyclerview == lottolist size
    override fun getItemCount(): Int {
        return lottoList.size
    }

}