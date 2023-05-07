package com.example.androidconcepts.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidconcepts.model.BmiResponseEntity
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

     fun calculateBmi(weight: String,height : String): String {
         var bmiResponse: BmiResponseEntity? = null
         viewModelScope.launch(Dispatchers.IO) {
             bmiResponse = bmiRepository.bmicalc(weight, height)
             Log.d("TAG", "calculateBmi: $bmiResponse")
         }

     }

}