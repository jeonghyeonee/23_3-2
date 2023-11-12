package com.example.selfintro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selfintro.databinding.ActivityProjectsBinding

class ProjectsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProjectsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding initialization
        binding = ActivityProjectsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Display profile information
        showProfileInfo()

        // Display the list of projects
        showProjectList()
    }

    /**
     * Function to show profile information in the UI.
     */
    private fun showProfileInfo() {
        binding.profileName.text = "Jeonghyeon Lee"
        binding.profileDescription.text = "POSITIVE WAVE\nHello! I'm Jeonghyeon Lee, \naspiring Software Engineer residing"
    }

    /**
     * Function to display the list of projects using RecyclerView.
     */
    private fun showProjectList() {
        // Create a list of projects (replace with your data)
        val projects = listOf(
            Project("TrenD Catcher",
                "\'Is it possible to find the backward Linkage Effect " +
                        "through Twitter tweets, the world's largest SNS?\'",
                R.drawable.trend, "https://github.com/jeonghyeonee/TrenD_Catcher"),
            Project("Memoriary",
                "Memoriary is is a combination of the words \"Memory\" and \"Diary.\" " +
                        "It was coined with the intention of preventing memory loss among our primary " +
                        "user group, the elderly, by using our app's core feature, the Diary.",
                R.drawable.memoriary, "https://github.com/jeonghyeonee/Memoriary")
        )

        // Create an adapter for projects
        val projectAdapter = ProjectAdapter(projects) { githubLink ->
            openGitHubLink(githubLink)
        }

        // Set the adapter to the RecyclerView
        binding.recyclerProjects.adapter = projectAdapter

        // Set a layout manager for the RecyclerView
        binding.recyclerProjects.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Function to open the GitHub link in a web browser.
     */
    private fun openGitHubLink(githubLink: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubLink))
        startActivity(intent)
    }
}
