package com.example.lottogenerator

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lottogenerator.databinding.NumberlistRecyclerBinding

class RecyclerViewAdapter(private val context: Context, private val lottoNumberList: List<LottoNumbersEntity>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NumberlistRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = lottoNumberList[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return lottoNumberList.size
    }

    inner class ViewHolder(private val binding: NumberlistRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LottoNumbersEntity) {
            with(binding) {
                num1.text = item.num1.toString()
                num2.text = item.num2.toString()
                num3.text = item.num3.toString()
                num4.text = item.num4.toString()
                num5.text = item.num5.toString()
                num6.text = item.num6.toString()
            }
        }
    }
}
