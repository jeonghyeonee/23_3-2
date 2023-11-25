package com.example.hw05

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("name", "")
        val age = sharedPreferences.getString("age", "")
        val studentNumber = sharedPreferences.getString("studentNumber", "")
        val city = sharedPreferences.getString("city", "")

        binding.textViewName.text = "$name"
        binding.textViewAge.text = "age"
        binding.textViewStudentNum.text = "$studentNumber"
        binding.textViewCity.text = "$city"

        return view
    }
}
