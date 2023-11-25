package com.example.hw05

interface DataTransferListener {
    fun onPersonalInfoFilled(student: Student)
    fun onAddressInfoFilled(address: String, postalCode: String, city: String)
}