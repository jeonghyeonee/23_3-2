package com.example.selfintro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.selfintro.databinding.ItemRecyclerviewBinding

/**
 * Adapter class for the RecyclerView that displays a list of work experiences.
 *
 * @param workExperiences List of WorkExperience objects to be displayed.
 */
class WorkExperienceAdapter(private val workExperiences: List<WorkExperience>) :
    RecyclerView.Adapter<WorkExperienceAdapter.ViewHolder>() {

    /**
     * ViewHolder class to hold the views for each item in the RecyclerView.
     *
     * @param binding Data binding object for the item layout.
     */
    class ViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // Declare the necessary views within the ViewHolder
        val jobTitle: TextView = binding.title
        val companyName: TextView = binding.subTitle
        val duration: TextView = binding.duration
        val experienceImage: ImageView = binding.img
    }

    /**
     * Function to create a new ViewHolder instance.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    /**
     * Function to bind data to the ViewHolder.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to views
        val experience = workExperiences[position]
        holder.jobTitle.text = experience.jobTitle
        holder.companyName.text = experience.companyName
        holder.duration.text = experience.duration
        holder.experienceImage.setImageResource(experience.imageResource)
    }

    /**
     * Function to get the total number of items in the list.
     */
    override fun getItemCount(): Int {
        return workExperiences.size
    }
}
