package com.example.hw05

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class PersonalInfoFragment : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var studentNumEditText: EditText
    private lateinit var nextButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_info, container, false)

        nameEditText = view.findViewById(R.id.nameEditText)
        ageEditText = view.findViewById(R.id.ageEditText)
        studentNumEditText = view.findViewById(R.id.studentNumEditText)
        nextButton = view.findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            // Get the entered information
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()
            val studentNumber = studentNumEditText.text.toString()

            // Save information to SharedPreferences
            saveToSharedPreferences(name, age, studentNumber)

            // Display a message or perform any other action as needed
            Toast.makeText(requireContext(), "Information saved!", Toast.LENGTH_SHORT).show()

            // Move to AddressInfoFragment
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.middleFragmentContainer, AddressInfoFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return view
    }

    private fun saveToSharedPreferences(name: String, age: String, studentNumber: String) {
        // Use SharedPreferences to save the information
        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("age", age)
        editor.putString("studentNumber", studentNumber)
        editor.apply()
    }
}