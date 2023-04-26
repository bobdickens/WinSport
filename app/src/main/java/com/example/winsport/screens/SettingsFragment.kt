package com.example.winsport.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.winsport.*
import com.example.winsport.databinding.FragmentSettingsBinding

 class SettingsFragment : Fragment() {

lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clear()
    }

    private fun clear() {
        binding.btnClear.setOnClickListener {
            val value = ""
            APP.app_name.edit().putString(APP_NAME_SET, value).apply()
            APP.app_height.edit().putString(APP_HEIGHT_SET, value).apply()
            APP.app_mass.edit().putString(APP_MASS_SET, value).apply()
            APP.app_distance.edit().putString(APP_DISTANCE_SET, value).apply()
            APP.app_squats.edit().putString(APP_SQUATS_SET, value).apply()
            APP.navController.navigate(R.id.action_settingsFragment_to_personFragment)
            APP.app_points.edit().putString(APP_POINTS_SET, value).apply()
        }
    }


}