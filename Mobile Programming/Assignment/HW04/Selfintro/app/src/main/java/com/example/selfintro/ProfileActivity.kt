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

        // 프로필 액티비티의 로직을 추가하세요.
        showProfileInfo()
        showWorkExperiences()
    }

    private fun showProfileInfo() {
        // 예시로 이름과 간단한 소개를 텍스트 뷰에 표시
        binding.profileName.text = "Jeonghyeon Lee"
        binding.profileIntroduction.text = "Hello! I'm Jeonghyeon Lee, \naspiring Software Engineer residing"
    }

    private fun showWorkExperiences() {
        // Create a list of Work Experiences (replace with your data)
        val workExperiences = listOf(
            Item("Software Engineer", "ABC Inc.", "2020 - Present", R.drawable.intel),
            Item("Intern", "XYZ Corp.", "2019 - 2020", R.drawable.intel)
            // Add more work experiences as needed
        )

        // Create an adapter for Work Experiences
        val recyclerViewAdapter = RecyclerViewAdapter(workExperiences)

        // Set the adapter to the RecyclerView
        binding.recyclerItem.adapter = recyclerViewAdapter

        // You can also set a layout manager if needed
        binding.recyclerItem.layoutManager = LinearLayoutManager(this)
    }
}





