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
import com.example.hw05.databinding.FragmentAddressInfoBinding

class AddressInfoFragment : Fragment() {

    private lateinit var onDataTransferListener: OnDataTransferListener
    private lateinit var cityEditText: EditText
    private lateinit var postalCodeEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var doneButton: Button

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
        val view = inflater.inflate(R.layout.fragment_address_info, container, false)

        // Initialize UI components
        cityEditText = view.findViewById(R.id.cityEditText)
        postalCodeEditText = view.findViewById(R.id.postalCodeEditText)
        addressEditText = view.findViewById(R.id.addressEditText)
        doneButton = view.findViewById(R.id.doneButton)

        // Set click listener for the "Done" button
        doneButton.setOnClickListener {
            // Get the entered address information
            val city = cityEditText.text.toString()
            val postalCode = postalCodeEditText.text.toString()
            val address = addressEditText.text.toString()

            // Create an AddressInfo instance
            val addressInfo = AddressInfo(city, postalCode, address)

            // Notify MainActivity about the data transfer
            onDataTransferListener.onAddressInfoDataTransfer(addressInfo)

            // Replace the current fragment in the bottom container with ResultFragment
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.bottomFragmentContainer, ResultFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return view
    }
}