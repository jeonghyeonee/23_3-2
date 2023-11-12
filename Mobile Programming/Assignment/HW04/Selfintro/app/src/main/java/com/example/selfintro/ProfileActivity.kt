package com.example.selfintro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selfintro.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Show the profile information
        showProfileInfo()

        // Show the work experiences
        showWorkExperiences()

        // Show the education details
        showEducation()

        // Show the extracurricular activities
        showActivities()
    }

    /**
     * Function to display the profile information.
     */
    private fun showProfileInfo() {
        binding.profileName.text = "Jeonghyeon Lee"
        binding.profileIntroduction.text = "POSITIVE WAVE\nHello! I'm Jeonghyeon Lee, \naspiring Software Engineer residing"

        // Display skills information
        val skillsText = """
            Kotlin, Java, Android, Python, C, MySQL, EC2, DynamoDB, Oracle, Lambda, AWS HTML, CSS, JavaScript, PHP, Hadoop, Hive
        """.trimIndent()
        binding.skillContents.text = skillsText
    }

    /**
     * Function to display work experiences using a RecyclerView.
     */
    private fun showWorkExperiences() {
        // Create a list of Work Experiences (replace with your data)
        val workExperiences = listOf(
            WorkExperience("Undergrade Technical Intern", "Intel Korea", "2022.09. ~ 2023.09. ", R.drawable.intel),
        )

        // Create an adapter for Work Experiences
        val workExperienceAdapter = WorkExperienceAdapter(workExperiences)

        // Set the adapter to the RecyclerView
        binding.recyclerWorkExperience.adapter = workExperienceAdapter

        // You can also set a layout manager if needed
        binding.recyclerWorkExperience.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Function to display education details using a RecyclerView.
     */
    private fun showEducation() {
        // Create a list of Education (replace with your data)
        val educations = listOf(
            Education("Seoul National University of Science and Technology", "ITM", "2020.03. ~ ", R.drawable.seoultech),
            Education("Northumbria University Newcastle", "ITMB", "2020.03. ~ ", R.drawable.northum)
        )

        // Create an adapter for Education
        val educationAdapter = EducationAdapter(educations)

        // Set the adapter to the RecyclerView
        binding.recyclerEducation.adapter = educationAdapter

        // You can also set a layout manager if needed
        binding.recyclerEducation.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Function to display extracurricular activities using a RecyclerView.
     */
    private fun showActivities() {
        // Create a list of Activities (replace with your data)
        val activities = listOf(
            Activity("GDSC(Google Developer Student Clubs) Seoul National University of Science and Technology",
                "Deep Learning Core", "2023.08. ~", R.drawable.gdsc),
            Activity("ACC (AWS Cloud Clubs) SeoulTech", "Co-Captain",
                "2023.07. ~ ", R.drawable.acc),
            Activity("Seoul National University of Science and Technology",
                "Team Leader, Hi Hadoop (Global Challenger)", "2022.05. ~ 2022.10.", R.drawable.hadoop),
            Activity("BOAZ(Bigdata is Our A to Z) Union Club",
                "17th President", "2021.07. ~ 2022.08.", R.drawable.boaz),
            Activity("STEM(Seoul Tech Encouraging Mentor) Student Ambassador",
                "Vice President", "2021.05. ~ ", R.drawable.stem)
        )

        // Create an adapter for Activities
        val activitiesAdapter = ActivitiesAdapter(activities)

        // Set the adapter to the RecyclerView
        binding.recyclerActivities.adapter = activitiesAdapter

        // You can also set a layout manager if needed
        binding.recyclerActivities.layoutManager = LinearLayoutManager(this)
    }
}