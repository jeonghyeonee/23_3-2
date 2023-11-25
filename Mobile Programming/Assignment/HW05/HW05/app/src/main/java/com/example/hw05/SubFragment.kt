package com.example.hw05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentSubBinding

class SubFragment : Fragment() {

    companion object {
        const val TAG = "SubFragment"
    }

    private lateinit var binding: FragmentSubBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubBinding.inflate(inflater, container, false)
        return binding.root
    }

    // 데이터를 받아와 UI 업데이트하는 메서드
    fun displayReviewData(student: Student) {
        // 여기에 데이터를 UI에 표시하는 코드 추가
        binding.textViewName.text = "Name: ${student.name}"
        binding.textViewStudentNum.text = "Student Num: ${student.studentNumber}"
        binding.textViewAge.text = "Age: ${student.age}"
        binding.textViewCity.text = "City: ${student.city}"
        // 필요한 항목 추가
    }
}