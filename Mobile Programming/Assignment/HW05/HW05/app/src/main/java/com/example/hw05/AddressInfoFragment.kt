package com.example.hw05

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentAddressInfoBinding

class AddressInfoFragment : Fragment() {

    private lateinit var binding: FragmentAddressInfoBinding
    private lateinit var dataTransferListener: DataTransferListener

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

            dataTransferListener.onAddressInfoFilled(address, postalCode, city)

            // Done 버튼을 누를 때 SubFragment 업데이트
            updateSubFragment()
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

    private fun updateSubFragment() {
        // SubFragment 업데이트 코드 추가
        val subFragment = SubFragment()
        val bundle = Bundle()
        bundle.putString("name", "")
        bundle.putInt("age", 0)
        bundle.putString("studentNumber", "")
        bundle.putString("city", binding.cityEditText.text.toString())
        bundle.putString("postalCode", binding.postalCodeEditText.text.toString())
        bundle.putString("address", binding.addressEditText.text.toString())
        subFragment.arguments = bundle

        // SubFragment를 FragmentTransaction을 통해 추가
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.bottomFragmentContainer, subFragment)
        transaction.commit()
    }
}
