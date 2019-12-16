package com.iamidin.moviecatalogue

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var photo: Int,
    var name: String,
    var directed: String,
    var genre: String,
    var rating: Float,
    var description: String
) : Parcelable