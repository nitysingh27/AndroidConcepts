package com.example.androidconcepts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BmrResposneEntity(
    var info: BmrInfo
) : Parcelable