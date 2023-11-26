package com.example.hw05

import android.os.Parcel
import android.os.Parcelable
data class AddressInfo(
    val city: String,
    val postalCode: String,
    val address: String
) : Parcelable {
    // Implementing the Parcelable interface requires defining writeToParcel and createFromParcel methods.

    // Write the object's properties to the parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(city)
        parcel.writeString(postalCode)
        parcel.writeString(address)
    }

    // Create an object from the parcel
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddressInfo> {
        override fun createFromParcel(parcel: Parcel): AddressInfo {
            return AddressInfo(
                parcel.readString() ?: "",
                parcel.readString() ?: "",
                parcel.readString() ?: ""
            )
        }

        override fun newArray(size: Int): Array<AddressInfo?> {
            return arrayOfNulls(size)
        }
    }
}

