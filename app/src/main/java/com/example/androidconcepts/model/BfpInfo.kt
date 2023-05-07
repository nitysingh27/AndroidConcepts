package com.example.androidconcepts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

    @Parcelize
    data class BfpInfo(
        val bfp: Double,
        val gender: String
    ) : Parcelable
