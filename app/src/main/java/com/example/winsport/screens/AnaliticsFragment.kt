package com.example.winsport.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.winsport.*
import com.example.winsport.databinding.FragmentAnaliticsBinding

class AnaliticsFragment : Fragment() {

lateinit var binding: FragmentAnaliticsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnaliticsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {

        binding.edDistance.setText(APP.app_distance.getString(APP_DISTANCE_SET, ""))
        binding.edSquats.setText(APP.app_squats.getString(APP_SQUATS_SET, ""))

        binding.btnEnter.setOnClickListener {
            val value_distance = binding.edDistance.text.toString()
            APP.app_distance.edit().putString(APP_DISTANCE_SET, value_distance).apply()

            val value_squats = binding.edSquats.text.toString()
            APP.app_squats.edit().putString(APP_SQUATS_SET, value_squats).apply()



        }
    }

}