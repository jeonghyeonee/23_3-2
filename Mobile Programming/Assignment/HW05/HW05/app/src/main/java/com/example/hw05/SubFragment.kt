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

        // Set initial state - show welcome message
        showWelcomeState()

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

        // Personal Information, Address Information 입력이 완료되면 UI 업데이트
        showAfterInputViews()
    }

    private fun showWelcomeState() {
        // 초기 상태 - Welcome 메시지만 보이게 설정
//        binding.textWelcome.visibility = View.VISIBLE
        binding.confirmationText.visibility = View.GONE
        binding.textViewName.visibility = View.GONE
        binding.textViewStudentNum.visibility = View.GONE
        binding.textViewAge.visibility = View.GONE
        binding.textViewCity.visibility = View.GONE
        binding.reviewText.visibility = View.GONE
    }

    private fun showAfterInputViews() {
        // Personal Information, Address Information 입력이 완료된 후에 호출되어야 하는 함수
        // 여기에서는 각 뷰의 가시성을 변경하여 보이게 설정
        binding.confirmationText.visibility = View.VISIBLE
        binding.textViewName.visibility = View.VISIBLE
        binding.textViewStudentNum.visibility = View.VISIBLE
        binding.textViewAge.visibility = View.VISIBLE
        binding.textViewCity.visibility = View.VISIBLE
        binding.reviewText.visibility = View.VISIBLE
    }
}
