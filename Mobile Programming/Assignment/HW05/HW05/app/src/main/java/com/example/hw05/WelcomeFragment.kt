package com.example.hw05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentWelcomeBinding

// Fragment to display a welcome message
class WelcomeFragment : Fragment() {

    // View Binding instance for the fragment's layout
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using View Binding
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}
