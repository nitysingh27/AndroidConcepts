package com.example.androidconcepts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BfpInfo(
    val bfp: Double,
    val gender: String,
    val fat_mass: Double,
    val lean_mass: Double,
    val description: String,
) : Parcelable
