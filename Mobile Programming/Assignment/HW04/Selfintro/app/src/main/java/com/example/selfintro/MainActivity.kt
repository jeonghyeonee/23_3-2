package com.example.selfintro

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.selfintro.databinding.ActivityMainBinding

/**
 * Main activity of the application responsible for displaying the main screen.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /**
     * Called when the activity is first created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Click listener for the "Go to Profile" button
        binding.btnGoToProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // Click listener for the "Go to Projects" button
        binding.btnGoToProjects.setOnClickListener {
            startActivity(Intent(this, ProjectsActivity::class.java))
        }

        // Click listener for the "Contact" button
        binding.btnContact.setOnClickListener {
            showContactPopup()
        }
    }

    /**
     * Function to display the contact popup.
     */
    private fun showContactPopup() {
        // Inflate the layout for the contact popup
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.contact_popup, null)

        // Add functionality to the email and LinkedIn buttons in the popup
        view.findViewById<Button>(R.id.btnEmail).setOnClickListener {
            sendEmail()
        }

        view.findViewById<Button>(R.id.btnLinkedIn).setOnClickListener {
            openLinkedInProfile()
        }

        // Create a popup dialog
        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        // Display the popup
        val alertDialog = builder.create()
        alertDialog.show()
    }

    /**
     * Function to open the default email app with a pre-filled email address.
     */
    private fun sendEmail() {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:workhappyj@gmail.com")
        startActivity(emailIntent)
    }

    /**
     * Function to open the LinkedIn profile in a web browser.
     */
    private fun openLinkedInProfile() {
        val linkedInIntent = Intent(Intent.ACTION_VIEW)
        linkedInIntent.data = Uri.parse("https://www.linkedin.com/in/jeonghyeon-lee-9b6380223/")
        startActivity(linkedInIntent)
    }
}
