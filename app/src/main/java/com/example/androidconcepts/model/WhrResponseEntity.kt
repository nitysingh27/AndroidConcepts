package com.example.androidconcepts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WhrResponseEntity(
    var whrInfo : WhrInfo
):Parcelable
