package com.example.androidconcepts.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidconcepts.model.BmiResponseEntity
import com.example.androidconcepts.model.BmrResponseEntity
import com.example.androidconcepts.model.Info
import com.example.androidconcepts.repository.BmiRepository
import com.example.androidconcepts.repository.BmrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BmrFragmentViewModel @Inject constructor(
    private var bmrRepository: BmrRepository
) : ViewModel() {
    //var bmrRepository : BmrRepository = BmrRepository()

    /*fun calculateBmr(weight: String, height: String,age :String,gender :String): String {

        return bmrRepository.bmrcalc(weight,height,age,gender)
    }*/
    var liveDataResponse : MutableLiveData<BmrResponseEntity> = MutableLiveData()
    fun calculateBmr(weight: String,height : String,age : String,gender : String): MutableLiveData<BmrResponseEntity> {
        var bmrResponse: BmrResponseEntity? = null
        viewModelScope.launch(Dispatchers.IO) {
            //   bmiResponse = bmiRepository.bmicalc(weight, height)
            liveDataResponse.postValue(bmrResponse?: BmrResponseEntity(0.0," "))
            //Log.d("TAG", "calculateBmi: $bmiResponse")
        }
        return liveDataResponse

    }

}