package com.example.winsport

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.winsport.databinding.ActivityMainBinding
import com.example.winsport.screens.PersonFragment
import java.util.*
import kotlin.time.Duration.Companion.milliseconds

const val APP_NAME = "APP_NAME"
const val APP_NAME_SET = "APP_NAME_SET"
const val APP_MASS = "APP_MASS"
const val APP_MASS_SET = "APP_MASS_SET"
const val APP_HEIGHT = "APP_HEIGHT"
const val APP_HEIGHT_SET = "APP_HEIGHT_SET"

const val APP_DISTANCE = "APP_DISTANCE"
const val APP_DISTANCE_SET = "APP_DISTANCE_SET"
const val APP_SQUATS = "APP_SQUATS"
const val APP_SQUATS_SET = "APP_SQUATS_SET"
const val APP_POINTS = "APP_POINTS"
const val APP_POINTS_SET = "APP_POINTS_SET"
const val APP_DAY = "APP_DAY"
const val APP_DAY_SET = "APP_DAY_SET"
const val APP_DAY_CHECK = "APP_DAY_CHECK"
const val APP_DAY_CHECK_SET = "APP_DAY_CHECK_SET"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var app_mass: SharedPreferences
    lateinit var app_height: SharedPreferences
    lateinit var app_distance: SharedPreferences
    lateinit var app_squats: SharedPreferences
    lateinit var app_name: SharedPreferences

    lateinit var app_points: SharedPreferences
    lateinit var app_day: SharedPreferences
    lateinit var app_day_check: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APP = this
        navController = Navigation.findNavController(this, R.id.nav_fragment)






        app_name = getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)
        app_mass = getSharedPreferences(APP_MASS, Context.MODE_PRIVATE)
        app_height = getSharedPreferences(APP_HEIGHT, Context.MODE_PRIVATE)
        app_distance = getSharedPreferences(APP_DISTANCE, Context.MODE_PRIVATE)
        app_squats = getSharedPreferences(APP_SQUATS, Context.MODE_PRIVATE)
        app_points = getSharedPreferences(APP_POINTS, Context.MODE_PRIVATE)
        app_day = getSharedPreferences(APP_DAY, Context.MODE_PRIVATE)
        app_day_check = getSharedPreferences(APP_DAY_CHECK, Context.MODE_PRIVATE)








        if (app_name.getString(APP_NAME_SET, "") == "" &&
              app_mass.getString(APP_MASS_SET, "") == "" &&
                app_height.getString(APP_HEIGHT_SET, "") == ""){supportFragmentManager.beginTransaction().add(R.id.nav_fragment, PersonFragment.newInstance() ).commit()}


    }

}