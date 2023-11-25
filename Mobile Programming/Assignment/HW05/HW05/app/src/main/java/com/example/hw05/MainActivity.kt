package com.example.hw05

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.addMemberButton).setOnClickListener {
            // Replace the existing fragment with the new member fragment
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.middleFragmentContainer, PersonalInfoFragment())
            fragmentTransaction.addToBackStack(null) // Add to back stack for back navigation
            fragmentTransaction.commit()
        }
    }
}
