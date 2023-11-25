package com.example.hw05

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentAddressInfoBinding

class AddressInfoFragment : Fragment() {

    private lateinit var binding: FragmentAddressInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddressInfoBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.doneButton.setOnClickListener {
            val city = binding.cityEditText.text.toString()
            val postalCode = binding.postalCodeEditText.text.toString()
            val address = binding.addressEditText.text.toString()

            saveAddressToSharedPreferences(city, postalCode, address)

            // Perform any other actions as needed

            // For example, show a toast message
             Toast.makeText(requireContext(), "Address information saved!", Toast.LENGTH_SHORT).show()

            // You can navigate to the next fragment or perform other actions here
        }

        return view
    }

    private fun saveAddressToSharedPreferences(city: String, postalCode: String, address: String) {
        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("city", city)
        editor.putString("postalCode", postalCode)
        editor.putString("address", address)
        editor.apply()
    }
}