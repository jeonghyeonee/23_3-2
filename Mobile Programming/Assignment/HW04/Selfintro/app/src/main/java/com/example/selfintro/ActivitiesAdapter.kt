package com.example.selfintro

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.selfintro.databinding.ItemRecyclerviewBinding

class ActivitiesAdapter(private val activities: List<Activity>) :
    RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // ViewHolder 내부에서 필요한 View들을 선언
        val activityName: TextView = binding.title
        val organization: TextView = binding.subTitle
        val year: TextView = binding.duration
        val activityImage: ImageView = binding.img
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 데이터 바인딩
        val activity = activities[position]
        holder.activityName.text = activity.orgTitle
        holder.organization.text = activity.subTitle
        holder.year.text = activity.duration
        holder.activityImage.setImageResource(activity.imageResource)
    }

    override fun getItemCount(): Int {
        return activities.size
    }
}