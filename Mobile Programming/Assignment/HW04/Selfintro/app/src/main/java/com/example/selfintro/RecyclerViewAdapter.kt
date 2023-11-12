package com.example.selfintro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selfintro.databinding.ItemRecyclerviewBinding

class RecyclerViewAdapter(private val workExperiences: List<Item>) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(private val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemList: Item) {
            // Set data to views using view binding
            binding.experienceJobTitle.text = itemList.jobTitle
            binding.experienceCompanyName.text = itemList.companyName
            binding.experienceDuration.text = itemList.duration
            binding.experienceImage.setImageResource(itemList.imageUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val workExperience = workExperiences[position]
        holder.bind(workExperience)
    }

    override fun getItemCount(): Int {
        return workExperiences.size
    }
}