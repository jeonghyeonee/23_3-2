package com.example.hw05

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

        // Argument에서 데이터를 받아오기
        val name = arguments?.getString("name")
        val age = arguments?.getString("age")
        val studentNumber = arguments?.getString("studentNumber")
        val city = arguments?.getString("city")

        // 받아온 데이터를 화면에 표시
        binding.textViewName.text = "Name: $name"
        binding.textViewAge.text = "Age: $age"
        binding.textViewStudentNum.text = "Student Num: $studentNumber"
        binding.textViewCity.text = "City: $city"

        return view
    }
}
