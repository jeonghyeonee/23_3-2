package com.example.selfintro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selfintro.databinding.ItemProjectBinding

/**
 * Adapter class for the RecyclerView that displays a list of projects.
 *
 * @property projects List of Project objects to be displayed.
 * @property onProjectItemClick Callback function to handle item click events.
 */
class ProjectAdapter(
    private val projects: List<Project>,
    private val onProjectItemClick: (String) -> Unit // Change type to String for GitHub Link
) : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    /**
     * Function to create a new ViewHolder instance.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProjectBinding.inflate(inflater, parent, false)
        return ProjectViewHolder(binding)
    }

    /**
     * Function to bind data to the ViewHolder.
     */
    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project = projects[position]
        holder.bind(project)
        holder.itemView.setOnClickListener {
            onProjectItemClick(project.githubLink)
        }
    }

    /**
     * Function to get the total number of items in the list.
     */
    override fun getItemCount(): Int = projects.size

    /**
     * ViewHolder class to hold the views for each item in the RecyclerView.
     */
    inner class ProjectViewHolder(private val binding: ItemProjectBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Function to bind project data to the views.
         */
        fun bind(project: Project) {
            binding.projectTitle.text = project.projectName
            binding.projectDescription.text = project.projectDescription
            binding.githubLink.text = project.githubLink
            binding.projectImage.setImageResource(project.projectImageResId)
        }
    }
}
