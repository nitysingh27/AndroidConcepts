package com.example.androidconcepts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BfpResposneEntity(
    var info: BfpInfo
) : Parcelable