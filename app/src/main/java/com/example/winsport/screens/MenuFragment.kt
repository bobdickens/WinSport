package com.example.winsport.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.winsport.*
import com.example.winsport.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.textPoints.text = APP.app_points.getString(APP_POINTS_SET, "0").toString()
        init()
    }

    private fun init() {


        binding.btnTraining.setOnClickListener {
            APP.navController.navigate(R.id.action_menuFragment_to_trainingFragment)
        }

        binding.btnAnalytics.setOnClickListener {
            APP.navController.navigate(R.id.action_menuFragment_to_analiticsFragment)
        }
        binding.btnSettings.setOnClickListener {
            APP.navController.navigate(R.id.action_menuFragment_to_settingsFragment)
        }
    }

    private fun parsing(){


    }

}