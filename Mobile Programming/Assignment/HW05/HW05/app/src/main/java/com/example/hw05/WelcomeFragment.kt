package com.example.hw05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun displayWelcomeMessage(name: String, age: Int, studentNumber: String, city: String) {
        val welcomeMessage = "Welcome, $name!\nAge: $age\nStudent Number: $studentNumber\nCity: $city"
        binding.textWelcome.text = welcomeMessage
    }
}