package com.project.githubuserapp.data

import android.os.Parcel
import android.os.Parcelable

data class GithubUsers(
        var username: String? = "",
        var name:String? = "",
        var avatar: Int? = 0,
        var company: String? = "",
        var location: String? = "",
        var repository: String? = "",
        var follower: String? = "",
        var following: String? = ""
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(username)
                parcel.writeString(name)
                parcel.writeInt(avatar!!)
                parcel.writeString(company)
                parcel.writeString(location)
                parcel.writeString(repository)
                parcel.writeString(follower)
                parcel.writeString(following)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<GithubUsers> {
                override fun createFromParcel(parcel: Parcel): GithubUsers {
                        return GithubUsers(parcel)
                }

                override fun newArray(size: Int): Array<GithubUsers?> {
                        return arrayOfNulls(size)
                }
        }
}