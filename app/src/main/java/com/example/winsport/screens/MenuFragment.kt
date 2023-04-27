package com.example.winsport.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.winsport.*
import com.example.winsport.databinding.FragmentMenuBinding
import java.util.*


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
            val calendar: Calendar = Calendar.getInstance()
            val day: Int = calendar.get(Calendar.DAY_OF_WEEK)
            APP.app_day.edit().putString(APP_DAY_SET, day.toString()).apply()

            val check = APP.app_day.getString(APP_DAY_SET, "")
            Log.d("calendarFinal", check.toString())

            val checkDay = APP.app_day_check.getString(APP_DAY_CHECK_SET, "")

            if(check != checkDay){
                val value = ""
                APP.app_distance.edit().putString(APP_DISTANCE_SET, value).apply()
                APP.app_squats.edit().putString(APP_SQUATS_SET, value).apply()
                APP.app_points.edit().putString(APP_POINTS_SET, value).apply()

                APP.app_day_check.edit().putString(APP_DAY_CHECK_SET, check).apply()
            }

            APP.navController.navigate(R.id.action_menuFragment_to_analiticsFragment)
        }
        binding.btnSettings.setOnClickListener {
            APP.navController.navigate(R.id.action_menuFragment_to_settingsFragment)
        }
    }

    private fun parsing(){


    }

}