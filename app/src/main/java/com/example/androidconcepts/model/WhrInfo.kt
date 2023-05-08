package com.example.androidconcepts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WhrInfo(
    val whr: Double,
    val gender: String,
) : Parcelable