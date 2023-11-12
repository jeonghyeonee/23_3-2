package com.example.selfintro

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.selfintro.databinding.ItemRecyclerviewBinding

class EducationAdapter(private val educations: List<Education>) :
    RecyclerView.Adapter<EducationAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // ViewHolder 내부에서 필요한 View들을 선언
        val degree: TextView = binding.title
        val major: TextView = binding.subTitle
        val graduationYear: TextView = binding.duration
        val educationImage: ImageView = binding.img
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 데이터 바인딩
        val education = educations[position]
        holder.degree.text = education.educationDegree
        holder.major.text = education.major
        holder.graduationYear.text = education.duration
        holder.educationImage.setImageResource(education.imageResource)
    }

    override fun getItemCount(): Int {
        return educations.size
    }
}
