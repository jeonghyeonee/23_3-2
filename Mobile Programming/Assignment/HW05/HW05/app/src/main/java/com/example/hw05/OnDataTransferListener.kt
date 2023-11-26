package com.example.hw05

interface OnDataTransferListener {
    fun onPersonalInfoDataTransfer(studentInfo: StudentInfo)
    fun onAddressInfoDataTransfer(addressInfo: AddressInfo)
    fun getStudentInfo(): StudentInfo
    fun getAddressInfo(): AddressInfo
}