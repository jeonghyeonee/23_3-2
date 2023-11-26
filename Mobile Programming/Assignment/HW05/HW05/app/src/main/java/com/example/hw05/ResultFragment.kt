package com.example.hw05

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentResultBinding
import android.os.Parcelable

// Import the AddressInfo class
import com.example.hw05.AddressInfo

// Fragment to display the result based on saved information in SharedPreferences
class ResultFragment : Fragment() {

    // View Binding instance for the fragment's layout
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        // Display retrieved information in the corresponding TextViews
        binding.textViewName.text = (requireActivity() as? OnDataTransferListener)?.getStudentInfo()?.name
        binding.textViewAge.text = (requireActivity() as? OnDataTransferListener)?.getStudentInfo()?.age
        binding.textViewCity.text = (requireActivity() as? OnDataTransferListener)?.getAddressInfo()?.city
        binding.textViewStudentNum.text = (requireActivity() as? OnDataTransferListener)?.getStudentInfo()?.studentNumber

        return view
    }


}
