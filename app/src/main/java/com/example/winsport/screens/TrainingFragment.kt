package com.example.winsport.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.winsport.APP
import com.example.winsport.R
import com.example.winsport.databinding.FragmentTrainingBinding
import java.util.*

class TrainingFragment : Fragment() {
        lateinit var binding: FragmentTrainingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTrainingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_trainingFragment_to_menuFragment)
        }


        val calendar: Calendar = Calendar.getInstance()
        val day: Int = calendar.get(Calendar.DAY_OF_WEEK)
        Log.d("calendar", "$day")

        when (day) {

            Calendar.MONDAY -> {binding.tvOnDay.text = getString(R.string.Monday)
                binding.tvTextScroll.text = getString(R.string.text_monday)
                binding.scrollImage.setImageResource(R.drawable.monday)}
            Calendar.TUESDAY -> {binding.tvOnDay.text = getString(R.string.Tuesday)
                binding.tvTextScroll.text = getString(R.string.text_tuesday)
                binding.scrollImage.setImageResource(R.drawable.tuesday)}
            Calendar.WEDNESDAY -> {binding.tvOnDay.text = getString(R.string.Wednesday)
                binding.tvTextScroll.text = getString(R.string.text_wednesday)
                binding.scrollImage.setImageResource(R.drawable.wednsday)
            }
            Calendar.THURSDAY -> {binding.tvOnDay.text = getString(R.string.Thursday)
                binding.tvTextScroll.text = getString(R.string.text_thursday)
                binding.scrollImage.setImageResource(R.drawable.thursday)}
            Calendar.FRIDAY -> {binding.tvOnDay.text = getString(R.string.Friday)
                binding.tvTextScroll.text = getString(R.string.text_friday)
                binding.scrollImage.setImageResource(R.drawable.friday)}
        }
            //binding.tvOnDay.text = APP.dayOfMonth.toString()
    }

}