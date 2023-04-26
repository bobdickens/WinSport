package com.example.winsport.screens

import android.animation.ObjectAnimator
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
        binding.progress.max = 25000
        val progress = binding.progress

        val checkPoints = APP.app_points.getString(APP_POINTS_SET, "1")

        if (checkPoints == "") {APP.app_points.edit().putString(APP_POINTS_SET, "0").apply()}
        val checkPoints2 = APP.app_points.getString(APP_POINTS_SET, "1")
        ObjectAnimator.ofInt(progress, "progress", checkPoints2!!.toInt() ).setDuration(1000).start()
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_analiticsFragment_to_menuFragment)
        }
//        binding.edDistance.setText(APP.app_distance.getString(APP_DISTANCE_SET, "0"))
//        binding.edSquats.setText(APP.app_squats.getString(APP_SQUATS_SET, "0"))
        binding.textProgressPoints.text = APP.app_points.getString(APP_POINTS_SET, "1")

        binding.btnEnter.setOnClickListener {
            val value_distance = binding.edDistance.text.toString()
            val value_squats = binding.edSquats.text.toString()

            if (value_distance != "" && value_squats != ""){
                val vale_dist_int = value_distance.toInt()


                val value_sq_int = value_squats.toInt()
                //APP.app_squats.edit().putString(APP_SQUATS_SET, value_squats).apply()

                val mass = (APP.app_mass.getString(APP_MASS_SET, "1"))?.toInt()


                //val points = (((dist!!*1000 + sq!!*10)*mass!!)/10)
                val points = ((vale_dist_int*1000 + value_sq_int*10)* mass!!)/10

                val current_points = APP.app_points.getString(APP_POINTS_SET, "1")?.toInt()
                val current_points2 = (current_points?.plus(points)).toString()

                APP.app_points.edit().putString(APP_POINTS_SET, current_points2).apply()


                binding.textProgressPoints.text = APP.app_points.getString(APP_POINTS_SET, "1")


                ObjectAnimator.ofInt(progress, "progress", current_points2.toInt() ).setDuration(1000).start()

            }


            //APP.app_distance.edit().putString(APP_DISTANCE_SET, value_distance).apply()

        }



    }


}