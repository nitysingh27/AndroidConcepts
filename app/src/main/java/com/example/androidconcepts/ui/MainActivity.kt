package com.example.androidconcepts.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidconcepts.R
import com.example.androidconcepts.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        binding?.bmi?.setOnClickListener {
            displayBmi()
        }
    }


    private fun displayBmi() {
        binding?.mainActivity?.visibility = View.GONE
        binding?.fragmentContainer?.visibility = View.VISIBLE
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, BmiFragment())
            .addToBackStack(" ").commit()
    }
}
