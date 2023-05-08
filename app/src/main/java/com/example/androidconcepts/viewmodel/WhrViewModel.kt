package com.example.androidconcepts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidconcepts.model.BmrInfo
import com.example.androidconcepts.model.WhrInfo
import com.example.androidconcepts.model.WhrResponseEntity
import com.example.androidconcepts.repository.WhrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WhrViewModel @Inject constructor(
    private var whrRepository: WhrRepository
) : ViewModel() {

    var liveDataResponse : MutableLiveData<WhrInfo> = MutableLiveData()
    //var whrRepository : WhrRepository? = null

    fun calculateWhr(waist :String,hip:String,gender:String): MutableLiveData<WhrInfo>{
        var whrResponse : WhrInfo
        viewModelScope.launch(Dispatchers.IO) {
            whrResponse = whrRepository.calcwhr(waist,hip, gender)
            liveDataResponse.postValue(whrResponse ?: WhrInfo("0.0", " ", "", ""))
        }
        return liveDataResponse
    }
}