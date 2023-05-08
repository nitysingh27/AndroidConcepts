package com.example.androidconcepts.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidconcepts.R
import com.example.androidconcepts.databinding.FragmentWhrBinding
import com.example.androidconcepts.viewmodel.BmrFragmentViewModel
import com.example.androidconcepts.viewmodel.WhrViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WhrFragment : Fragment() {
    var whrFragmentBinding : FragmentWhrBinding? = null
    private val whrViewModel: WhrViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        whrFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_whr, container, false)
        whrFragmentBinding?.whrCalculate?.setOnClickListener {
            calculate()
        }
        return whrFragmentBinding?.root
    }

    @SuppressLint("SetTextI18n")
    fun calculate() {
        var waist = whrFragmentBinding?.whrWaist?.text.toString()
        var hip = whrFragmentBinding?.whrHip?.text.toString()
        var gender = whrFragmentBinding?.whrGender?.text.toString()
        var result = whrViewModel?.calculateWhr(waist, hip,gender)
        whrFragmentBinding?.whrResult?.visibility = View.VISIBLE
        result?.observe(viewLifecycleOwner) {
            whrFragmentBinding?.whrResult?.visibility = View.VISIBLE
            // bmrFragmentBinding?.bmrResult?.text = "${it.info.bmi} , ${it.info.health}"
            whrFragmentBinding?.whrResult?.text = "${it.whr.toString()} , ${it.gender}"
        }

        //whrFragmentBinding?.whrResult?.text=result
    }



}