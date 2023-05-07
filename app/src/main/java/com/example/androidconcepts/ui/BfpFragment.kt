package com.example.androidconcepts.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.androidconcepts.R
import com.example.androidconcepts.databinding.BfpFragmentBinding
import com.example.androidconcepts.databinding.FragmentBmrBinding
import com.example.androidconcepts.viewmodel.BfpViewModel
import com.example.androidconcepts.viewmodel.BmiFragmentViewModel
import com.example.androidconcepts.viewmodel.BmrFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BfpFragment : androidx.fragment.app.Fragment() {
    var bmrFragmentBinding: BfpFragmentBinding? = null
    private val bmrViewModel: BfpViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*bmiViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[BmiFragmentViewModel::class.java]*/
        bmrFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_bmr, container, false)
        bmrFragmentBinding?.bmrCalculate?.setOnClickListener {
            calculate()
        }
        return bmrFragmentBinding?.root
    }

    @SuppressLint("SetTextI18n")
    fun calculate() {
        var weight = bmrFragmentBinding?.bmrWeight?.text.toString()
        var height = bmrFragmentBinding?.bmrHeight?.text.toString()
        var age = bmrFragmentBinding?.bmrAge?.text.toString()
        var gender = bmrFragmentBinding?.bmrGender?.text.toString()
        var result = bmrViewModel?.calculateBmr(weight, height,age,gender)
        result?.observe(viewLifecycleOwner) {
            bmrFragmentBinding?.bmrResult?.visibility = View.VISIBLE
            // bmrFragmentBinding?.bmrResult?.text = "${it.info.bmi} , ${it.info.health}"
            bmrFragmentBinding?.bmrResult?.text = "${it.bmr.toString()} , ${it.gender}"
        }

    }
}
