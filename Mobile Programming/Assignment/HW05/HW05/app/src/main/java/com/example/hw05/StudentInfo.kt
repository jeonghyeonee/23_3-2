package com.example.hw05

import android.os.Parcel
import android.os.Parcelable

data class StudentInfo(
    val name: String,
    val age: String,
    val studentNumber: String
) : Parcelable {
    // Implementing the Parcelable interface requires defining writeToParcel and createFromParcel methods.

    // Write the object's properties to the parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(age)
        parcel.writeString(studentNumber)
    }

    // Create an object from the parcel
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StudentInfo> {
        override fun createFromParcel(parcel: Parcel): StudentInfo {
            return StudentInfo(
                parcel.readString() ?: "",
                parcel.readString() ?: "",
                parcel.readString() ?: ""
            )
        }

        override fun newArray(size: Int): Array<StudentInfo?> {
            return arrayOfNulls(size)
        }
    }
}

