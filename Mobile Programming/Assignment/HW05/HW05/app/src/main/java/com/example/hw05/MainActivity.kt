package com.example.hw05

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.hw05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnDataTransferListener {

    private lateinit var studentInfo: StudentInfo
    private lateinit var addressInfo: AddressInfo
    // ViewBinding instance for the activity's layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listener using ViewBinding
        binding.addMemberButton.setOnClickListener {
            // Replace the existing fragment with the new member fragment
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.middleFragmentContainer, PersonalInfoFragment())
            fragmentTransaction.addToBackStack(null) // Add to back stack for back navigation
            fragmentTransaction.commit()
        }

        // Load saved data if available
        studentInfo = getStoredStudentInfo()
        addressInfo = getStoredAddressInfo()

        // Show the welcome fragment by default
        showWelcomeFragment()
    }


    // Implementation of the interface for data transfer from fragment to activity
    override fun onPersonalInfoDataTransfer(studentInfo: StudentInfo) {
        // Save the transferred data to SharedPreferences
        saveStudentInfoToSharedPreferences(studentInfo)
        // Update the local data
        this.studentInfo = studentInfo
        // Show the result in ResultFragment
        showWelcomeFragment()
    }

    override fun onAddressInfoDataTransfer(addressInfo: AddressInfo) {
        // Save the transferred data to SharedPreferences
        saveAddressInfoToSharedPreferences(addressInfo)
        // Update the local data
        this.addressInfo = addressInfo
        // Show the result in ResultFragment
        showResultFragment()
    }

    override fun getStudentInfo(): StudentInfo {
        return studentInfo
    }

    override fun getAddressInfo(): AddressInfo {
        return addressInfo
    }


    private fun saveStudentInfoToSharedPreferences(studentInfo: StudentInfo) {
        // Use SharedPreferences to save the student information
        val editor = getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
        editor.putString("name", studentInfo.name)
        editor.putString("age", studentInfo.age)
        editor.putString("studentNumber", studentInfo.studentNumber)
        editor.apply()
    }

    private fun saveAddressInfoToSharedPreferences(addressInfo: AddressInfo) {
        // Use SharedPreferences to save the address information
        val editor = getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
        editor.putString("city", addressInfo.city)
        editor.putString("postalCode", addressInfo.postalCode)
        editor.putString("address", addressInfo.address)
        editor.apply()
    }

    private fun getStoredStudentInfo(): StudentInfo {
        // Retrieve stored student information from SharedPreferences
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", null)
        val age = sharedPreferences.getString("age", null)
        val studentNumber = sharedPreferences.getString("studentNumber", null)

        // Return a default StudentInfo if any of the required information is missing
        return StudentInfo(name ?: "", age ?: "", studentNumber ?: "")
    }

    private fun getStoredAddressInfo(): AddressInfo {
        // Retrieve stored address information from SharedPreferences
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val city = sharedPreferences.getString("city", null)
        val postalCode = sharedPreferences.getString("postalCode", null)
        val address = sharedPreferences.getString("address", null)

        // Return a default AddressInfo if any of the required information is missing
        return AddressInfo(city ?: "", postalCode ?: "", address ?: "")
    }

    private fun showWelcomeFragment() {
        val welcomeFragment = WelcomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottomFragmentContainer, welcomeFragment)
            .commit()
    }

    private fun showResultFragment() {
        // Determine which fragment to show based on whether addressInfo is available
        val fragmentToShow = if (addressInfo.address.isNotEmpty()) {
            // Show ResultFragment if addressInfo is available
            ResultFragment()
        } else {
            // Show WelcomeFragment if addressInfo is not available
            WelcomeFragment()
        }

        // Pass the necessary data to the fragment
        val bundle = Bundle()
        bundle.putParcelable("studentInfo", studentInfo)
        bundle.putParcelable("addressInfo", addressInfo)
        fragmentToShow.arguments = bundle

        // Replace the fragment in the bottom container
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottomFragmentContainer, fragmentToShow)
            .commit()
    }



}

