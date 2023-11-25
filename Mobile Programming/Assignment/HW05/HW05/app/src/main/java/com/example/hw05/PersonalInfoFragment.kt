package com.example.hw05

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hw05.databinding.FragmentPersonalInfoBinding

class PersonalInfoFragment : Fragment() {

    private lateinit var binding: FragmentPersonalInfoBinding
    private lateinit var dataTransferListener: DataTransferListener
    private lateinit var personalInfoViewModel: PersonalInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalInfoBinding.inflate(inflater, container, false)
        val view = binding.root

        // ViewModel 초기화
        personalInfoViewModel = ViewModelProvider(this).get(PersonalInfoViewModel::class.java)

        binding.nextButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val age = binding.ageEditText.text.toString().toIntOrNull() ?: 0
            val studentNumber = binding.studentNumEditText.text.toString()

            // PersonalInfoViewModel에 Student 데이터 저장
            personalInfoViewModel.student = Student(name, age, studentNumber, null, null, null)

            // 데이터 전송
            dataTransferListener.onPersonalInfoFilled(personalInfoViewModel.student!!)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DataTransferListener) {
            dataTransferListener = context
        } else {
            throw ClassCastException("$context must implement DataTransferListener")
        }
    }
}