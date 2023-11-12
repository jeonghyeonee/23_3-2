package com.example.selfintro

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.selfintro.databinding.ItemRecyclerviewBinding

/**
 * Adapter class for displaying extracurricular activities information in a RecyclerView.
 *
 * @param activities List of Activity objects to be displayed.
 */
class ActivitiesAdapter(private val activities: List<Activity>) :
    RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>() {

    /**
     * ViewHolder class to hold the necessary views for each item in the RecyclerView.
     *
     * @param binding ItemRecyclerviewBinding object representing the layout of each item.
     */
    class ViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // Views needed within the ViewHolder are declared here
        val activityName: TextView = binding.title
        val organization: TextView = binding.subTitle
        val year: TextView = binding.duration
        val activityImage: ImageView = binding.img
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
        val activity = activities[position]
        holder.activityName.text = activity.orgTitle
        holder.organization.text = activity.subTitle
        holder.year.text = activity.duration
        holder.activityImage.setImageResource(activity.imageResource)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     */
    override fun getItemCount(): Int {
        return activities.size
    }
}
