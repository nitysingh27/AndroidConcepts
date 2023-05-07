package com.example.androidconcepts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BmiResponseEntity(
    val info: BmiInfo
) : Parcelable