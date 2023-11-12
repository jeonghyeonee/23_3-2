package com.example.selfintro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.selfintro.databinding.ItemRecyclerviewBinding

class WorkExperienceAdapter(private val workExperiences: List<WorkExperience>) :
    RecyclerView.Adapter<WorkExperienceAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // ViewHolder 내부에서 필요한 View들을 선언
        val jobTitle: TextView = binding.title
        val companyName: TextView = binding.subTitle
        val duration: TextView = binding.duration
        val experienceImage: ImageView = binding.img
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 데이터 바인딩
        val experience = workExperiences[position]
        holder.jobTitle.text = experience.jobTitle
        holder.companyName.text = experience.companyName
        holder.duration.text = experience.duration
        holder.experienceImage.setImageResource(experience.imageResource)
    }

    override fun getItemCount(): Int {
        return workExperiences.size
    }
}