package com.example.selfintro

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.selfintro.databinding.ItemRecyclerviewBinding

/**
 * Adapter class for displaying education information in a RecyclerView.
 *
 * @param educations List of Education objects to be displayed.
 */
class EducationAdapter(private val educations: List<Education>) :
    RecyclerView.Adapter<EducationAdapter.ViewHolder>() {

    /**
     * ViewHolder class to hold the necessary views for each item in the RecyclerView.
     *
     * @param binding ItemRecyclerviewBinding object representing the layout of each item.
     */
    class ViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // Views needed within the ViewHolder are declared here
        val degree: TextView = binding.title
        val major: TextView = binding.subTitle
        val graduationYear: TextView = binding.duration
        val educationImage: ImageView = binding.img
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to the views
        val education = educations[position]
        holder.degree.text = education.educationDegree
        holder.major.text = education.major
        holder.graduationYear.text = education.duration
        holder.educationImage.setImageResource(education.imageResource)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     */
    override fun getItemCount(): Int {
        return educations.size
    }
}
