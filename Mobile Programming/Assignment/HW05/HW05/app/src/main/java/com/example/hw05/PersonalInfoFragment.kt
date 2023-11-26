package com.example.hw05

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class PersonalInfoFragment : Fragment() {

    private lateinit var onDataTransferListener: OnDataTransferListener
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var studentNumEditText: EditText
    private lateinit var nextButton: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDataTransferListener) {
            onDataTransferListener = context
        } else {
            throw ClassCastException("$context must implement OnDataTransferListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_info, container, false)

        // Initialize UI components
        nameEditText = view.findViewById(R.id.nameEditText)
        ageEditText = view.findViewById(R.id.ageEditText)
        studentNumEditText = view.findViewById(R.id.studentNumEditText)
        nextButton = view.findViewById(R.id.nextButton)

        // Set click listener for the "Next" button
        nextButton.setOnClickListener {
            // Get the entered information
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()
            val studentNumber = studentNumEditText.text.toString()

            // Create a StudentInfo instance
            val studentInfo = StudentInfo(name, age, studentNumber)

            // Notify MainActivity about the data transfer
            onDataTransferListener.onPersonalInfoDataTransfer(studentInfo)

            // Move to AddressInfoFragment
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.middleFragmentContainer, AddressInfoFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return view
    }
}