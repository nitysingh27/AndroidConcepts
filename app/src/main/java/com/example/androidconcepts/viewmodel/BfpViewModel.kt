package com.example.androidconcepts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidconcepts.model.BfpInfo
import com.example.androidconcepts.model.BmrInfo
import com.example.androidconcepts.repository.BfpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BfpViewModel @Inject constructor(
    var bfpRepository: BfpRepository
) : ViewModel() {
    var liveDataResponse: MutableLiveData<BfpInfo> = MutableLiveData()
    var bfpResponse: BfpInfo? = null
    fun calculateBfp(
        weight: String,
        height: String,
        age: String,
        gender: String
    ): MutableLiveData<BfpInfo> {
        var bmrResponse: BmrInfo? = null
        viewModelScope.launch(Dispatchers.IO) {
            bfpResponse = bfpRepository.bfpcalc(weight, height, age, gender)
            liveDataResponse.postValue(bfpResponse ?: BfpInfo(0.0, "", 0.0, 0.0, ""))

        }
        return liveDataResponse

    }

}