package com.example.androidconcepts.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.androidconcepts.R
import com.example.androidconcepts.databinding.FragmentBmiBinding
import com.example.androidconcepts.viewmodel.BmiFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BmiFragment : androidx.fragment.app.Fragment() {
    var bmiFragmentBinding: FragmentBmiBinding? = null
    private val bmiViewModel: BmiFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*bmiViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[BmiFragmentViewModel::class.java]*/
        bmiFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_bmi, container, false)
        bmiFragmentBinding?.bmiCalculate?.setOnClickListener {
            calculate()
        }
        return bmiFragmentBinding?.root
    }

    fun calculate() {
        var weight = bmiFragmentBinding?.bmiWeight?.text.toString()
        var height = bmiFragmentBinding?.bmiHeight?.text.toString()
        var result = bmiViewModel?.calculateBmi(weight, height)
        bmiFragmentBinding?.bmiResult?.visibility = View.VISIBLE
        bmiFragmentBinding?.bmiResult?.text = result
    }
}