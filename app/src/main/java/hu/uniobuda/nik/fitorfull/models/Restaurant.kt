package hu.uniobuda.nik.fitorfull.models

import android.os.Parcel
import android.os.Parcelable

data class Restaurant(
        var name: String,
        var address: String,
        var openingHours: String,
        var phoneNumber: String,
        var freeSpace: String,
        var maxSpace: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeString(openingHours)
        parcel.writeString(phoneNumber)
        parcel.writeString(freeSpace)
        parcel.writeString(maxSpace)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Restaurant> {
        override fun createFromParcel(parcel: Parcel): Restaurant {
            return Restaurant(parcel)
        }

        override fun newArray(size: Int): Array<Restaurant?> {
            return arrayOfNulls(size)
        }
    }
}