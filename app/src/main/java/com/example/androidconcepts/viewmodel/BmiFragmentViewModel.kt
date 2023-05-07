package com.example.androidconcepts.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidconcepts.model.BmiResponseEntity
import com.example.androidconcepts.model.Info
import com.example.androidconcepts.repository.BmiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BmiFragmentViewModel @Inject constructor(
    private var bmiRepository: BmiRepository
) : ViewModel() {
    //var bmiRepository : BmiRepository = BmiRepository()

    var liveDataResponse : MutableLiveData<BmiResponseEntity> = MutableLiveData()
     fun calculateBmi(weight: String,height : String): MutableLiveData<BmiResponseEntity> {
         var bmiResponse: BmiResponseEntity? = null
         viewModelScope.launch(Dispatchers.IO) {
          //   bmiResponse = bmiRepository.bmicalc(weight, height)
             liveDataResponse.postValue(bmiResponse?: BmiResponseEntity(info = Info(0.0,"","")))
             Log.d("TAG", "calculateBmi: $bmiResponse")
         }
         return liveDataResponse

     }

}