package com.example.hw05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    // View Binding instance for the fragment's layout
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        // Cast once to avoid multiple casts
        val dataTransferListener = requireActivity() as? OnDataTransferListener

        // Display retrieved information in the corresponding TextViews
        binding.textViewName.text = dataTransferListener?.getStudentInfo()?.name
        binding.textViewAge.text = dataTransferListener?.getStudentInfo()?.age
        binding.textViewCity.text = dataTransferListener?.getAddressInfo()?.city
        binding.textViewStudentNum.text = dataTransferListener?.getStudentInfo()?.studentNumber

        return view
    }
}

