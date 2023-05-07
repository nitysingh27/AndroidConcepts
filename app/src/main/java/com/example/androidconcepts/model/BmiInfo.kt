package com.example.androidconcepts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BmiInfo(
    val bmi: Double,
    val health: String,
    val healthy_bmi_range: String
) : Parcelable