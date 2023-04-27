package com.example.winsport.screens


import android.icu.number.IntegerWidth
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.winsport.*
import com.example.winsport.databinding.FragmentPersonBinding


class PersonFragment : Fragment() {
    lateinit var binding: FragmentPersonBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.edName.setText(APP.app_name.getString(APP_NAME_SET, "0"))
        binding.edHeight.setText(APP.app_height.getString(APP_HEIGHT_SET, "0"))
        binding.edMass.setText(APP.app_mass.getString(APP_MASS_SET, "0"))

        binding.btnStart.setOnClickListener {
            val value = binding.edName.text.toString()
            APP.app_name.edit().putString(APP_NAME_SET, value).apply()

            val value_height = binding.edHeight.text.toString()
            APP.app_height.edit().putString(APP_HEIGHT_SET, value_height).apply()

            val value_mass = binding.edMass.text.toString()
            APP.app_mass.edit().putString(APP_MASS_SET, value_mass).apply()

            APP.navController.navigate(R.id.menuFragment)


        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PersonFragment()
    }


}
