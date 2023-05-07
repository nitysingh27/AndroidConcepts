package com.example.androidconcepts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BmrInfo(
    val bmr: Double,
    val gender: String
) : Parcelable