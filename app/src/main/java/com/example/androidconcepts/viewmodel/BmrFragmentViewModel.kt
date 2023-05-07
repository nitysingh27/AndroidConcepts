package com.example.androidconcepts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidconcepts.model.BmrInfo
import com.example.androidconcepts.repository.BmrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BmrFragmentViewModel @Inject constructor(
    private var bmrRepository: BmrRepository
) : ViewModel() {
    var liveDataResponse: MutableLiveData<BmrInfo> = MutableLiveData()
    fun calculateBmr(
        weight: String,
        height: String,
        age: String,
        gender: String
    ): MutableLiveData<BmrInfo> {
        var bmrResponse: BmrInfo? = null
        viewModelScope.launch(Dispatchers.IO) {
            bmrResponse = bmrRepository.bmrcalc(weight, height, age, gender)
            liveDataResponse.postValue(bmrResponse ?: BmrInfo(0.0, " "))
            //Log.d("TAG", "calculateBmi: $bmiResponse")
        }
        return liveDataResponse

    }

}