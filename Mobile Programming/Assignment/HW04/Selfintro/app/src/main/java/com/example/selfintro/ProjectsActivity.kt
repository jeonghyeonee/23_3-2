package com.example.selfintro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.selfintro.databinding.ActivityProjectsBinding

class ProjectsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProjectsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProjectsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 프로젝트 액티비티의 로직을 추가하세요.
    }
}